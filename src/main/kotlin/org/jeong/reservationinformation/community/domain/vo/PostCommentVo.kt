package org.jeong.reservationinformation.community.domain.vo

import java.util.*

data class PostCommentVo(
        val id: String,
        val userName: String,
        val comment: String,
        val registerDate: Date,
        val updateDate: Date
)