package org.jeong.reservationinformation.community.domain.vo

import org.jeong.reservationinformation.community.domain.enums.PostCategory

data class InsertPostVo(
        val userName: String,
        val password: String,
        val postCategory: PostCategory,
        val title: String,
        val content: String
)