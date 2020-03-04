package org.jeong.reservationinformation.reservation.sport.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SportReservationsResponseVo(
        val hasNext: Boolean,
        val reservations: List<PublicReservationSportVo>,
        val lastPage: Long? = null
)