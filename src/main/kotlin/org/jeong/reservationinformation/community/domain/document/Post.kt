package org.jeong.reservationinformation.community.domain.document

import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Post(
        @Id
        val id: String? = null,
        val userName: String,
        val password: String,
        val postCategory: PostCategory,
        var title: String,
        var content: String,
        var viewCount: Int? = 0,
        @CreatedDate
        val registerDate: Date? = null,
        @LastModifiedDate
        val updateDate: Date? = null
) {
        fun toPostVo(): PostVo {
                return PostVo(
                        id = this.id!!,
                        userName = userName,
                        content = content,
                        postCategory = postCategory,
                        title = title,
                        viewCount = viewCount!!,
                        updateDate = updateDate!!,
                        registerDate = registerDate!!
                )

        }
}