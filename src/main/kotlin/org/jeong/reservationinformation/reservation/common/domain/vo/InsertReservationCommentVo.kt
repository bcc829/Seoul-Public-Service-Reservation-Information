package org.jeong.reservationinformation.reservation.common.domain.vo

data class InsertReservationCommentVo(
        val svcId: String,
        val userName: String,
        val password: String,
        val rating: Int,
        val comment: String
)