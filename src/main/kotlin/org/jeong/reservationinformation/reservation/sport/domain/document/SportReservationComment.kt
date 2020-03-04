package org.jeong.reservationinformation.reservation.sport.domain.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class SportReservationComment(
        @Id
        val id: String? = null,
        val sportReservationSvcId: String,
        var userName: String,
        var password: String,
        var rating: Int,
        var comment: String
)