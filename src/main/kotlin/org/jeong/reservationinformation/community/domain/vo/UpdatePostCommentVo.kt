package org.jeong.reservationinformation.community.domain.vo

data class UpdatePostCommentVo(
        val id: String,
        val userName: String,
        val password: String,
        val comment: String
)