package org.jeong.reservationinformation.reservation.culture.domian.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CultureReservationComment(
        @Id
        val id: String? = null,
        val cultureReservationSvcId: String,
        var userName: String,
        var password: String,
        var rating: Int,
        var comment: String
)