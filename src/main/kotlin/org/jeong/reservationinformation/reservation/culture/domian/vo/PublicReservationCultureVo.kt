package org.jeong.reservationinformation.reservation.culture.domian.vo

import com.fasterxml.jackson.annotation.JsonProperty

data class PublicReservationCultureVo(
        @JsonProperty("GUBUN")
        val division: String,
        @JsonProperty("SVCID")
        val svcId: String,
        @JsonProperty("MAXCLASSNM")
        val mainCategory: String,
        @JsonProperty("MINCLASSNM")
        val subCategory: String,
        @JsonProperty("SVCSTATNM")
        val serviceStatus: String,
        @JsonProperty("SVCNM")
        val serviceName: String,
        @JsonProperty("PAYATNM")
        val paymentMethod: String,
        @JsonProperty("PLACENM")
        val placeName: String,
        @JsonProperty("USETGTINFO")
        val targetUser: String,
        @JsonProperty("SVCURL")
        val serviceUrl: String,
        @JsonProperty("X")
        val lat: String,
        @JsonProperty("Y")
        val lng: String,
        @JsonProperty("SVCOPNBGNDT")
        val serviceLaunchStartDateTime: String,
        @JsonProperty("SVCOPNENDDT")
        val serviceLaunchEndDateTime: String,
        @JsonProperty("RCPTBGNDT")
        val receptionStartDateTime: String,
        @JsonProperty("RCPTENDDT")
        val receptionEndDateTime: String,
        @JsonProperty("AREANM")
        val areaName: String,
        @JsonProperty("NOTICE")
        val notice: String,
        @JsonProperty("IMG_PATH")
        val imageUrl: String,
        @JsonProperty("TELNO")
        val Tel: String,
        @JsonProperty("V_MIN")
        val openingHours: String,
        @JsonProperty("V_MAX")
        val closingHours: String,
        @JsonProperty("REVSTDDAYNM")
        val cancellationPeriodInfo: String,
        @JsonProperty("REVSTDDAY")
        val cancellationPeriod: String
)