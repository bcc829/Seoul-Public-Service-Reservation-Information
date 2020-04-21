package org.jeong.reservationinformation.community.domain.document

import org.jeong.reservationinformation.community.domain.vo.PostCommentVo
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class PostComment (
        @Id
        val id: String? = null,
        val postId: String,
        val userName: String,
        val password: String,
        var comment: String,
        @CreatedDate
        val registerDate: Date? = null,
        @LastModifiedDate
        val updateDate: Date? = null
) {
        fun toPostCommentVo(): PostCommentVo {
                return PostCommentVo(id = this.id!!,
                        userName = this.userName,
                        comment = this.comment,
                        registerDate = this.registerDate!!,
                        updateDate = this.updateDate!!)
        }
}