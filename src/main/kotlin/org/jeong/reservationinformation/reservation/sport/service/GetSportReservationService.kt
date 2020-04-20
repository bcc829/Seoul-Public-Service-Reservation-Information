package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.reservation.sport.domain.enums.SportCategory
import org.jeong.reservationinformation.reservation.sport.domain.vo.ListPublicReservationSportResponseVo
import org.jeong.reservationinformation.reservation.sport.domain.vo.SportReservationsResponseVo
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class GetSportReservationService(
        @Value("\${api.key}")
        private val key: String,
        private val pageUtil: PageUtil
) {

    companion object {
        const val baseUrl = "http://openAPI.seoul.go.kr:8088/{key}/json/ListPublicReservationSport"
    }

    fun getReservationsWithPage(category: String, page: Int, size: Int): Mono<SportReservationsResponseVo> =
            WebClient.builder()
                    .baseUrl(baseUrl
                            .replace("{key}", key)
                            .plus(pageUtil.makePageUrl(page, size))
                            .plus((SportCategory
                                    .values()
                                    .firstOrNull { it.name.equals(category, true) } ?: SportCategory.ALL)
                                    .getSportCategoryKoreanName()))
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .exchangeStrategies(
                            ExchangeStrategies.builder()
                                    .codecs { it.defaultCodecs().maxInMemorySize(16 * 1024 * 1024) }
                                    .build()
                    )
                    .build()
                    .get()
                    .retrieve()
                    .bodyToMono(ListPublicReservationSportResponseVo::class.java)
                    .map {
                        when (it.ListPublicReservationSport == null) {
                            true -> SportReservationsResponseVo(
                                    hasNext = false,
                                    reservations = listOf()
                            )

                            false -> SportReservationsResponseVo(
                                    hasNext = it.ListPublicReservationSport.list_total_count > page * size,
                                    reservations = it.ListPublicReservationSport.row,
                                    lastPage = pageUtil.getLastPage(
                                            totalCount = it.ListPublicReservationSport.list_total_count,
                                            size = size
                                    )
                            )
                        }
                    }
}