package org.jeong.reservationinformation.reservation.sport.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ListPublicReservationSportVo (
        @JsonProperty("list_total_count")
        val list_total_count: Long,
        @JsonProperty("RESULT")
        val RESULT: ResultVo,
        @JsonProperty("row")
        val row: List<PublicReservationSportVo>
)