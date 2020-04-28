package org.jeong.reservationinformation.community.domain.vo

import org.jeong.reservationinformation.community.domain.document.PostComment

data class InsertPostCommentVo(
        val postId: String,
        val userName: String,
        val password: String,
        val comment: String
) {
    fun toPostComment(): PostComment {
        return PostComment(
                postId = postId,
                userName = userName,
                comment = comment,
                password = password
        )
    }
}