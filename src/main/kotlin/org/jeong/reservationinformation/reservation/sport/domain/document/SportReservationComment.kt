package org.jeong.reservationinformation.reservation.sport.domain.document

import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class SportReservationComment(
        @Id
        val id: String? = null,
        val sportReservationSvcId: String,
        val userName: String,
        val password: String,
        var rating: Int,
        var comment: String,
        @CreatedDate
        val registerDate: Date? = null,
        @LastModifiedDate
        val updateDate: Date? = null
) {
        fun toReservationCommentVo(): ReservationCommentVo =
                ReservationCommentVo(
                        id = this.id!!,
                        svcId = this.sportReservationSvcId,
                        rating = this.rating,
                        comment = this.comment,
                        userName = this.userName,
                        updateDate = this.updateDate,
                        registerDate = this.registerDate
                )
}