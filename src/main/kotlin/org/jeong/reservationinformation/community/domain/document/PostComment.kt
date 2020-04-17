package org.jeong.reservationinformation.community.domain.document

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class PostComment (
        @Id
        val id: String? = null,
        var userName: String,
        var password: String,
        var comment: String,
        @CreatedDate
        val registerDate: Date? = null,
        @LastModifiedDate
        val updateDate: Date? = null
)