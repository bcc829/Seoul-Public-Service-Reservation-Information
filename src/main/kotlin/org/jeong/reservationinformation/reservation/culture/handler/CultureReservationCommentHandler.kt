package org.jeong.reservationinformation.reservation.culture.handler

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.culture.service.CultureReservationCommentCrudService
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.security.InvalidParameterException

@Configuration
class CultureReservationCommentHandler(
        val cultureReservationCommentCrudService: CultureReservationCommentCrudService,
        val pageUtil: PageUtil
) {

    fun getCommentsBySvcIdWithPaging(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(cultureReservationCommentCrudService.getCultureReservationCommentBySvcIdWithPaging(
                            pageable = pageUtil.makePageRequest(request),
                            svcId = request.queryParam("svcId")
                                    .orElseThrow { InvalidParameterException("svcId is not exist") }
                    ), PaginatedObject::class.java)

    fun insertComment(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(InsertReservationCommentVo::class.java)
                    .flatMap {
                        if (it.rating !in 1..5) {
                            Mono.error(InvalidParameterException("The rating is between 1 and 5"))
                        } else {
                            ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(cultureReservationCommentCrudService.insertCultureReservationComment(
                                            insertReservationCommentVo = it
                                    ), ReservationCommentVo::class.java)
                        }
                    }.switchIfEmpty(
                            Mono.error(InvalidParameterException("request body is not exist"))
                    )

    fun updateComment(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(UpdateReservationCommentVo::class.java)
                    .flatMap {
                        if (it.rating !in 1..5) {
                            Mono.error(InvalidParameterException("The rating is between 1 and 5"))
                        } else {
                            ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(cultureReservationCommentCrudService.updateCultureReservationComment(
                                            updateReservationCommentVo = it
                                    ), ReservationCommentVo::class.java)
                        }
                    }.switchIfEmpty(
                            Mono.error(InvalidParameterException("request body is not exist"))
                    )

    fun deleteComment(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(cultureReservationCommentCrudService.deleteCultureReservationComment(
                            cultureReservationCommentId = request.queryParam("id")
                                    .orElseThrow { InvalidParameterException("id is not exist") },
                            password = request.queryParam("password")
                                    .orElseThrow { InvalidParameterException("password is not exist") }
                    ), Void::class.java)

}