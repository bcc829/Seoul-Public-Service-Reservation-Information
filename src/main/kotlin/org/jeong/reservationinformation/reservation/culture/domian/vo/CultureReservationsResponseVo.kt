package org.jeong.reservationinformation.reservation.culture.domian.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CultureReservationsResponseVo(
        val hasNext: Boolean,
        val reservationList: List<PublicReservationCultureVo>,
        val lastPage: Long? = null
)