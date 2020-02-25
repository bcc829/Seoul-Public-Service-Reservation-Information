package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.reservation.sport.domain.vo.ListPublicReservationSportResponseVo
import org.jeong.reservationinformation.reservation.sport.domain.vo.ReservationListResponseVo
import org.jeong.reservationinformation.reservation.sport.enum.SportCategory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import kotlin.math.ceil

@Service
class GetReservationService(
        @Value("\${api.key}")
        private val key: String
) {

    companion object {
        const val baseUrl = "http://openAPI.seoul.go.kr:8088/{key}/json/ListPublicReservationSport"
    }

    fun getReservationListWithPage(category: String, page: Int, size: Int): Mono<ReservationListResponseVo> =
            WebClient.builder()
                    .baseUrl(baseUrl
                            .replace("{key}", key)
                            .plus(makePageUrl(page, size))
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
                            true -> ReservationListResponseVo(
                                    hasNext = false,
                                    reservationList = listOf()
                            )

                            false -> ReservationListResponseVo(
                                    hasNext = it.ListPublicReservationSport.list_total_count > page * size,
                                    reservationList = it.ListPublicReservationSport.row,
                                    lastPage = getLastPage(
                                            totalCount = it.ListPublicReservationSport.list_total_count,
                                            size = size
                                    )
                            )
                        }
                    }


    private fun makePageUrl(page: Int, size: Int): String {

        assert(page > 0)
        assert(size <= 1000)

        val startIndex = (page - 1) * size + 1
        val endIndex = page * size

        return "/$startIndex/$endIndex/"
    }

    private fun getLastPage(totalCount: Long, size: Int): Long =
            ceil(totalCount / size.toDouble()).toLong()

}