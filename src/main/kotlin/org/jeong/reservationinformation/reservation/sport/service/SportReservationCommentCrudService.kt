package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface SportReservationCommentCrudService {
    fun getSportReservationCommentBySvcId(svcId: String): Flux<ReservationCommentVo>
    fun insertSportReservationComment(insertReservationCommentVo: InsertReservationCommentVo): Mono<ReservationCommentVo>
    fun updateSportReservationComment(updateReservationCommentVo: UpdateReservationCommentVo): Mono<ReservationCommentVo>
    fun deleteSportReservationComment(sportReservationCommentId: String, password: String): Mono<Void>
}