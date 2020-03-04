package org.jeong.reservationinformation.reservation.culture.handler

import org.jeong.reservationinformation.reservation.culture.domian.enums.CultureCategory
import org.jeong.reservationinformation.reservation.culture.domian.vo.CultureReservationsResponseVo
import org.jeong.reservationinformation.reservation.culture.service.GetCultureReservationService
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Configuration
class GetCultureReservationsHandler(
        private val getCultureReservationService: GetCultureReservationService
) {
    fun getReservations(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(getCultureReservationService.getReservationsWithPage(
                            category = request.queryParam("category")
                                    .map { it.toString() }
                                    .orElseGet { CultureCategory.ALL.name },
                            page = request.queryParam("page")
                                    .map { if(it.toInt() > 0) it.toInt() else 1 }
                                    .orElseGet { 1 },
                            size = request.queryParam("size")
                                    .map { if(it.toInt() > 1000) 1000 else it.toInt() }
                                    .orElseGet { 10 }
                    ), CultureReservationsResponseVo::class.java)

}