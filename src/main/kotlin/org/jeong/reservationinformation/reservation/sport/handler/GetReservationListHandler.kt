package org.jeong.reservationinformation.reservation.sport.handler

import org.jeong.reservationinformation.reservation.sport.domain.vo.ReservationListResponseVo
import org.jeong.reservationinformation.reservation.sport.enum.SportCategory
import org.jeong.reservationinformation.reservation.sport.service.GetReservationService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class GetReservationListHandler(
        private val getReservationService: GetReservationService
) {

    fun getReservationList(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(getReservationService.getReservationListWithPage(
                            category = request.queryParam("category")
                                    .map { it.toString() }
                                    .orElseGet { SportCategory.ALL.name },
                            page = request.queryParam("page")
                                    .map { it.toInt() }
                                    .orElseGet { 1 },
                            size = request.queryParam("size")
                                    .map { if(it.toInt() > 1000) 1000 else it.toInt() }
                                    .orElseGet { 10 }
                    ), ReservationListResponseVo::class.java)

}