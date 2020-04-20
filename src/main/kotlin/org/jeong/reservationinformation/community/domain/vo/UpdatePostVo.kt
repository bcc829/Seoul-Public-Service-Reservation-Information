package org.jeong.reservationinformation.community.domain.vo

data class UpdatePostVo(
        val userName: String,
        val password: String,
        val title: String,
        val content: String
)