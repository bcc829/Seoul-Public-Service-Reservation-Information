package org.jeong.reservationinformation.reservation.sport.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReservationListResponseVo(
        val hasNext: Boolean,
        val reservationList: List<PublicReservationSportVo>,
        val lastPage: Long? = null
)