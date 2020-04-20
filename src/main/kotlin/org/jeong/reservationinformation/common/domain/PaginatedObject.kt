package org.jeong.reservationinformation.common.domain

data class PaginatedObject<T>(
        val content : List<T>? = null,
        val pageInfo : PageInfo
)

data class PageInfo(
        val totalCount: Long,
        val hasNext: Boolean,
        val isLast: Boolean,
        val isFirst: Boolean,
        val numberOfElements: Int
)