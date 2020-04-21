package org.jeong.reservationinformation.reservation.culture.service

import org.jeong.reservationinformation.common.domain.PageInfo
import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.reservation.culture.domian.enums.CultureCategory
import org.jeong.reservationinformation.reservation.culture.domian.vo.CultureReservationsResponseVo
import org.jeong.reservationinformation.reservation.culture.domian.vo.ListPublicReservationCultureResponseVo
import org.jeong.reservationinformation.reservation.culture.domian.vo.PublicReservationCultureVo
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

    fun getReservationsWithPage(category: String, page: Int, size: Int): Mono<PaginatedObject<PublicReservationCultureVo>> =
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
                            true -> PaginatedObject(
                                    pageInfo = PageInfo(
                                            hasNext = false,
                                            isFirst = false,
                                            isLast = false,
                                            numberOfElements = 0,
                                            totalCount = 0,
                                            firstPage = 0,
                                            lastPage = 0
                                    ),
                                    content = listOf()
                            )

                            false -> {
                                val lastPage = pageUtil.getLastPage(
                                        totalCount = it.ListPublicReservationCulture.list_total_count,
                                        size = size
                                )

                                PaginatedObject(
                                        pageInfo = PageInfo(
                                                hasNext = it.ListPublicReservationCulture.list_total_count > page * size,
                                                totalCount = it.ListPublicReservationCulture.list_total_count,
                                                isFirst = page == 1,
                                                isLast = page == lastPage,
                                                numberOfElements = it.ListPublicReservationCulture.row.size,
                                                firstPage = 1,
                                                lastPage = lastPage
                                        ),
                                        content = it.ListPublicReservationCulture.row
                                )
                            }
                        }
                    }
}