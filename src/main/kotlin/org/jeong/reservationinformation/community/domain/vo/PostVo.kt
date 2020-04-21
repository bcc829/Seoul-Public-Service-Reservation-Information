package org.jeong.reservationinformation.community.domain.vo

import org.jeong.reservationinformation.community.domain.enums.PostCategory
import java.util.*

data class PostVo(
        val id: String,
        val userName: String,
        val postCategory: PostCategory,
        val title: String,
        val content: String,
        val viewCount: Int,
        val registerDate: Date,
        val updateDate: Date
)