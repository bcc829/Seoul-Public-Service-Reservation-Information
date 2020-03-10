package org.jeong.reservationinformation.reservation.culture.service

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CultureReservationCommentCrudService {
    fun getCultureReservationCommentBySvcId(svcId: String): Flux<ReservationCommentVo>
    fun insertCultureReservationComment(insertReservationCommentVo: InsertReservationCommentVo): Mono<ReservationCommentVo>
    fun updateCultureReservationComment(updateReservationCommentVo: UpdateReservationCommentVo): Mono<ReservationCommentVo>
    fun deleteCultureReservationComment(cultureReservationCommentId: String, password: String): Mono<Void>
}