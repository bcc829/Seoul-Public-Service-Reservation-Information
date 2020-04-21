package org.jeong.reservationinformation.common.domain

data class PageInfo(
        val totalCount: Long,
        val hasNext: Boolean,
        val isLast: Boolean,
        val isFirst: Boolean,
        val numberOfElements: Int,
        val firstPage: Int,
        val lastPage: Int
)