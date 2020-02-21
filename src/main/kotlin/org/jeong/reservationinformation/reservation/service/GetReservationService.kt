package org.jeong.reservationinformation.reservation.service

import org.jeong.reservationinformation.reservation.domain.vo.ListPublicReservationSportResponseVo
import org.jeong.reservationinformation.reservation.domain.vo.ReservationListResponseVo
import org.jeong.reservationinformation.reservation.enum.SportCategory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
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

    fun getReservationListWithPage(category: String, page: Int): Mono<ReservationListResponseVo> {
        val endIndex = page * 10

        var sportCategory = SportCategory
                .values()
                .firstOrNull { it.name.equals(category, true) }

        if(sportCategory == null) {
            sportCategory = SportCategory.ALL
        }

        val webClient = WebClient.builder()
                .baseUrl(baseUrl
                        .replace("{key}", key)
                        .plus(makePageUrl(page))
                        .plus(sportCategory.getSportCategoryKoreanName()))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()

        return webClient
                .get()
                .retrieve()
                .bodyToMono(ListPublicReservationSportResponseVo::class.java)
                .map { response ->
                    when (response.ListPublicReservationSport == null) {
                        true -> ReservationListResponseVo(
                                hasNext = false,
                                reservationList = listOf()
                        )

                        false -> ReservationListResponseVo(
                                        hasNext = response.ListPublicReservationSport.list_total_count > endIndex,
                                        reservationList = response.ListPublicReservationSport.row,
                                        lastPage = getLastPage(response.ListPublicReservationSport.list_total_count)
                        )
                    }
                }
    }


    private fun makePageUrl(page: Int): String {

        assert(page > 0)

        val startIndex = (page - 1) * 10 + 1
        val endIndex = page * 10

        return "/$startIndex/$endIndex/"
    }

    private fun getLastPage(totalCount: Long): Long {
        return ceil(totalCount / 10.0).toLong()
    }
}