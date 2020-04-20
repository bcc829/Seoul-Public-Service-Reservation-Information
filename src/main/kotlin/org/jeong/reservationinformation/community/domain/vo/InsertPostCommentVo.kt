package org.jeong.reservationinformation.community.domain.vo

import java.util.*

data class InsertPostCommentVo(
        val postId: String,
        val userName: String,
        val password: String,
        val comment: String,
        val registerDate: Date,
        val updateDate: Date
)