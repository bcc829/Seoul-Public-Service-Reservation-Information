package org.jeong.reservationinformation.reservation.sport.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.jeong.reservationinformation.reservation.common.domain.vo.ResultVo

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ListPublicReservationSportResponseVo(
        @JsonProperty("ListPublicReservationSport")
        val ListPublicReservationSport: ListPublicReservationSportVo?,
        @JsonProperty("RESULT")
        val RESULT: ResultVo?
)