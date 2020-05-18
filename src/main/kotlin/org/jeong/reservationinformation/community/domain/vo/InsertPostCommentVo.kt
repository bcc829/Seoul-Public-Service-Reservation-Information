package org.jeong.reservationinformation.community.domain.vo

import org.jeong.reservationinformation.community.domain.document.PostComment

data class InsertPostCommentVo(
        val postId: String,
        val username: String,
        val password: String,
        val comment: String
) {
    fun toPostComment(): PostComment {
        return PostComment(
                postId = postId,
                username = username,
                comment = comment,
                password = password
        )
    }
}