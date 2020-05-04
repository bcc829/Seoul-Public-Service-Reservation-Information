package org.jeong.reservationinformation.common.util

import org.jeong.reservationinformation.common.domain.PageInfo
import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import reactor.core.publisher.Mono
import kotlin.math.ceil

@Component
class PageUtil {
    fun makePageUrl(page: Int, size: Int): String {
        assert(page > 0)
        assert(size in 1..1000)

        val startIndex = (page - 1) * size + 1
        val endIndex = page * size

        return "/$startIndex/$endIndex/"
    }

    fun makePageRequest(request: ServerRequest): Pageable {
        var size = request.queryParam("size").orElse("10").toInt()
        val page = request.queryParam("page").orElse("1").toInt() - 1
        val sort = Sort.by(Sort.Order.desc("regDate"))

        if (size > 100) {
            size = 100
        }

        return PageRequest.of(size, page, sort)
    }

    fun <T> makePagingObjectPublisher(pageable: Pageable, monoTotalCount: Mono<Long>, monoPageContents: Mono<List<T>>)
            : Mono<PaginatedObject<T>> =
            Mono.zip(monoTotalCount, monoPageContents)
                    .map {
                        makePagingObject(pageable = pageable, totalCount = it.t1, pageContents = it.t2)
                    }


    fun <T> makePagingObject(pageable: Pageable, totalCount: Long, pageContents: List<T>): PaginatedObject<T> {
        val lastPage = getLastPage(totalCount, pageable.pageSize)

        return PaginatedObject(
                pageInfo = PageInfo(
                        totalCount = totalCount,
                        isLast = lastPage == pageable.pageNumber,
                        //one indexed page
                        isFirst = pageable.pageNumber + 1 == 1,
                        firstPage = 1,
                        lastPage = lastPage,
                        //one indexed page
                        hasNext = pageable.pageNumber + 1 < lastPage,
                        numberOfElements = pageContents.size
                ),
                content = pageContents
        )
    }

    fun getLastPage(totalCount: Long, size: Int): Int =
            ceil(totalCount / size.toDouble()).toInt()
}