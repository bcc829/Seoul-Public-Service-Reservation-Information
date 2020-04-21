package org.jeong.reservationinformation.common.util

import org.springframework.stereotype.Component
import kotlin.math.ceil

@Component
class PageUtil {
    fun makePageUrl(page: Int, size: Int): String {
        assert (page > 0)
        assert (size in 1..1000)

        val startIndex = (page - 1) * size + 1
        val endIndex = page * size

        return "/$startIndex/$endIndex/"
    }

    fun getLastPage(totalCount: Long, size: Int): Int =
            ceil(totalCount / size.toDouble()).toInt()
}