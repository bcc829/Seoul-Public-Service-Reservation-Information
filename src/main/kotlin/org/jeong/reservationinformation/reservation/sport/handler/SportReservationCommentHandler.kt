package org.jeong.reservationinformation.reservation.sport.handler

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.sport.service.SportReservationCommentCrudService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.badRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.security.InvalidParameterException

@Component
class SportReservationCommentHandler(
        private val sportReservationCommentCrudService: SportReservationCommentCrudService
) {

    fun getCommentsBySvcId(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(sportReservationCommentCrudService.getSportReservationCommentBySvcId(
                            svcId = request.queryParam("svcId")
                                    .orElseThrow { InvalidParameterException("svcId is not exist") }
                    ), ReservationCommentVo::class.java)

    fun insertComment(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(InsertReservationCommentVo::class.java)
                    .flatMap {
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(sportReservationCommentCrudService.insertSportReservationComment(
                                        insertReservationCommentVo = it
                                ), ReservationCommentVo::class.java)
                    }.switchIfEmpty(
                            badRequest()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .build()
                    )

    fun updateComment(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(UpdateReservationCommentVo::class.java)
                    .flatMap {
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(sportReservationCommentCrudService.updateSportReservationComment(
                                        updateReservationCommentVo = it,
                                        sportReservationCommentId = request.queryParam("id")
                                                .orElseThrow { InvalidParameterException("id is not exist") }
                                ), ReservationCommentVo::class.java)
                    }.switchIfEmpty(
                            badRequest()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .build()
                    )

    fun deleteComment(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(sportReservationCommentCrudService.deleteSportReservationComment(
                            sportReservationCommentId = request.queryParam("id")
                                    .orElseThrow { InvalidParameterException("id is not exist") },
                            password = request.queryParam("password")
                                    .orElseThrow { InvalidParameterException("password is not exist") }
                    ), Void::class.java)

}