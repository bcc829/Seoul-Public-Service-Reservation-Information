package org.jeong.reservationinformation.common.domain

data class PaginatedObject<T>(
        val content : List<T>,
        val pageInfo : PageInfo
)

