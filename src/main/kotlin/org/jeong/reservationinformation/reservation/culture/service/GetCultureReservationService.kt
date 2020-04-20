package org.jeong.reservationinformation.reservation.culture.service

import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.reservation.culture.domian.enums.CultureCategory
import org.jeong.reservationinformation.reservation.culture.domian.vo.CultureReservationsResponseVo
import org.jeong.reservationinformation.reservation.culture.domian.vo.ListPublicReservationCultureResponseVo
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class GetCultureReservationService(@Value("\${api.key}")
                                   private val key: String,
                                   private val pageUtil: PageUtil) {
    companion object {
        const val baseUrl = "http://openAPI.seoul.go.kr:8088/{key}/json/ListPublicReservationCulture"
    }

    fun getReservationsWithPage(category: String, page: Int, size: Int): Mono<CultureReservationsResponseVo> =
            WebClient.builder()
                    .baseUrl(baseUrl
                            .replace("{key}", key)
                            .plus(pageUtil.makePageUrl(page, size))
                            .plus((CultureCategory
                                    .values()
                                    .firstOrNull { it.name.equals(category, true) } ?: CultureCategory.ALL)
                                    .getCultureCategoryKoreanName()))
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .exchangeStrategies(
                            ExchangeStrategies.builder()
                                    .codecs { it.defaultCodecs().maxInMemorySize(16 * 1024 * 1024) }
                                    .build()
                    )
                    .build()
                    .get()
                    .retrieve()
                    .bodyToMono(ListPublicReservationCultureResponseVo::class.java)
                    .map {
                        when (it.ListPublicReservationCulture == null) {
                            true -> CultureReservationsResponseVo(
                                    hasNext = false,
                                    reservations = listOf()
                            )

                            false -> CultureReservationsResponseVo(
                                    hasNext = it.ListPublicReservationCulture.list_total_count > page * size,
                                    reservations = it.ListPublicReservationCulture.row,
                                    lastPage = pageUtil.getLastPage(
                                            totalCount = it.ListPublicReservationCulture.list_total_count,
                                            size = size
                                    )
                            )
                        }
                    }
}