package org.jeong.reservationinformation.reservation.common.domain.vo

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ReservationCommentVo(
        val id: String,
        val svcId: String,
        val userName: String,
        val rating: Int,
        val comment: String,
        val registerDate: Date? = null,
        val updateDate: Date? = null
)