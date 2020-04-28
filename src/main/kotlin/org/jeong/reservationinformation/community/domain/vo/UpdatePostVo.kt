package org.jeong.reservationinformation.community.domain.vo

data class UpdatePostVo(
        val id: String,
        val password: String,
        val title: String,
        val content: String
)