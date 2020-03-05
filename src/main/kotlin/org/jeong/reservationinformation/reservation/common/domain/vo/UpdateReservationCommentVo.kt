package org.jeong.reservationinformation.reservation.common.domain.vo

data class UpdateReservationCommentVo(
        val password: String,
        val comment: String,
        val rating: Int
)