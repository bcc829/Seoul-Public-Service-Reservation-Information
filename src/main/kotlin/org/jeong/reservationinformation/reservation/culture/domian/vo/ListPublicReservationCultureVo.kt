package org.jeong.reservationinformation.reservation.culture.domian.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.jeong.reservationinformation.reservation.common.domain.vo.ResultVo

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ListPublicReservationCultureVo (
        @JsonProperty("list_total_count")
        val list_total_count: Long,
        @JsonProperty("RESULT")
        val RESULT: ResultVo,
        @JsonProperty("row")
        val row: List<PublicReservationCultureVo>
)