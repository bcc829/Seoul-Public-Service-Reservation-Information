package org.jeong.reservationinformation.community.handler.post

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.service.post.PostSearchService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.lang.IllegalArgumentException

@Component
class PostSearchHandler(val postSearchService: PostSearchService) {

    fun getPostsWithPaging(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsAllWithPaging(pageable = makePageRequest(request)),
                            PaginatedObject::class.java
                    )

    fun getPostsByCategoryWithPaging(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByCategoryWithPaging(
                                    pageable = makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.queryParam("category")
                                                    .orElseThrow { IllegalArgumentException("category is missing") }
                                                    .toUpperCase()
                                    )

                            ),
                            PaginatedObject::class.java
                    )

    fun getPostsByContentLikeAndPostCategory(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByContentLikeAndCategoryWithPaging(
                                    pageable = makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.queryParam("category")
                                                    .orElseThrow { IllegalArgumentException("category is missing") }
                                                    .toUpperCase()
                                    ),
                                    content = request.queryParam("content")
                                            .orElseThrow { IllegalArgumentException("content is missing") }
                            ),
                            PaginatedObject::class.java
                    )


    fun getPostsByTitleLikeAndPostCategory(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByTitleLikeAndCategoryWithPaging(
                                    pageable = makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.queryParam("category")
                                                    .orElseThrow { IllegalArgumentException("category is missing") }
                                                    .toUpperCase()
                                    ),
                                    title = request.queryParam("title")
                                            .orElseThrow { IllegalArgumentException("title is missing") }
                            ),
                            PaginatedObject::class.java
                    )

    fun getPostsByUserNameLikeAndPostCategory(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByUserNameLikeAndCategoryWithPaging(
                                    pageable = makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.queryParam("category")
                                                    .orElseThrow { IllegalArgumentException("category is missing") }
                                                    .toUpperCase()
                                    ),
                                    userName = request.queryParam("userName")
                                            .orElseThrow { IllegalArgumentException("userName is missing") }
                            ),
                            PaginatedObject::class.java
                    )


    private fun makePageRequest(request: ServerRequest): Pageable {
        var size = request.queryParam("size").orElse("10").toInt()
        val page = request.queryParam("page").orElse("1").toInt() - 1
        val sort = Sort.by(Sort.Order.desc("regDate"))

        if (size > 100) {
            size = 100
        }

        return PageRequest.of(size, page, sort)
    }
}