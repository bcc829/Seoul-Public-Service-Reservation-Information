package org.jeong.reservationinformation.reservation.common.domain.vo

data class ReservationCommentVo(
        val id: String,
        val svcId: String,
        val userName: String,
        val rating: Int,
        val comment: String
)