package org.jeong.reservationinformation.reservation.culture.domian.document


import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class CultureReservationComment(
        @Id
        val id: String? = null,
        val cultureReservationSvcId: String,
        var userName: String,
        var password: String,
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
                        svcId = this.cultureReservationSvcId,
                        rating = this.rating,
                        comment = this.comment,
                        userName = this.userName,
                        updateDate = this.updateDate,
                        registerDate = this.registerDate
                )

}