package org.jeong.reservationinformation.reservation.sport.handler

import org.jeong.reservationinformation.reservation.sport.domain.vo.SportReservationsResponseVo
import org.jeong.reservationinformation.reservation.sport.domain.enums.SportCategory
import org.jeong.reservationinformation.reservation.sport.service.GetSportReservationService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class GetSportReservationsHandler(
        private val getSportReservationService: GetSportReservationService
) {

    fun getReservations(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(getSportReservationService.getReservationsWithPage(
                            category = request.queryParam("category")
                                    .map { it.toString() }
                                    .orElseGet { SportCategory.ALL.name },
                            page = request.queryParam("page")
                                    .map { it.toInt() }
                                    .orElseGet { 1 },
                            size = request.queryParam("size")
                                    .map { if(it.toInt() > 1000) 1000 else it.toInt() }
                                    .orElseGet { 10 }
                    ), SportReservationsResponseVo::class.java)

}