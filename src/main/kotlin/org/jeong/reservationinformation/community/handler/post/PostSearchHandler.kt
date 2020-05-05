package org.jeong.reservationinformation.community.handler.post

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.service.post.PostSearchService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class PostSearchHandler(val postSearchService: PostSearchService, val pageUtil: PageUtil) {

    fun getPostsWithPaging(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsAllWithPaging(pageable = pageUtil.makePageRequest(request)),
                            PaginatedObject::class.java
                    )

    fun getPostsByCategoryWithPaging(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByCategoryWithPaging(
                                    pageable = pageUtil.makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.pathVariable("category")
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
                                    pageable = pageUtil.makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.pathVariable("category")
                                                    .toUpperCase()
                                    ),
                                    content = request.queryParam("keyword")
                                            .orElseThrow { IllegalArgumentException("keyword is missing") }
                            ),
                            PaginatedObject::class.java
                    )


    fun getPostsByTitleLikeAndPostCategory(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByTitleLikeAndCategoryWithPaging(
                                    pageable = pageUtil.makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.pathVariable("category")
                                                    .toUpperCase()
                                    ),
                                    title = request.queryParam("keyword")
                                            .orElseThrow { IllegalArgumentException("keyword is missing") }
                            ),
                            PaginatedObject::class.java
                    )

    fun getPostsByUsernameLikeAndPostCategory(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postSearchService.findPostsByUserNameLikeAndCategoryWithPaging(
                                    pageable = pageUtil.makePageRequest(request),
                                    postCategory = PostCategory.valueOf(
                                            request.pathVariable("category")
                                                    .toUpperCase()
                                    ),
                                    username = request.queryParam("keyword")
                                            .orElseThrow { IllegalArgumentException("keyword is missing") }
                            ),
                            PaginatedObject::class.java
                    )

}