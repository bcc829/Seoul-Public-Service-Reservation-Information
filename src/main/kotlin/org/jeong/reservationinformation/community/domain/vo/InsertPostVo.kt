package org.jeong.reservationinformation.community.domain.vo

import org.jeong.reservationinformation.community.domain.document.Post
import org.jeong.reservationinformation.community.domain.enums.PostCategory

data class InsertPostVo(
        val userName: String,
        val password: String,
        val postCategory: PostCategory,
        val title: String,
        val content: String
) {
    fun toPost(): Post {
        return Post(
                username = userName,
                password = password,
                postCategory = postCategory,
                title = title,
                content = content
        )
    }
}