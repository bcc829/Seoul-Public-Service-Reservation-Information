package org.jeong.reservationinformation.community.handler.comment

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.community.domain.vo.InsertPostCommentVo
import org.jeong.reservationinformation.community.domain.vo.PostCommentVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostCommentVo
import org.jeong.reservationinformation.community.service.comment.PostCommentCrudService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.security.InvalidParameterException

@Component
class PostCommentHandler(val postCommentCrudService: PostCommentCrudService, val pageUtil: PageUtil) {

    fun insertPostComment(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(InsertPostCommentVo::class.java)
                    .flatMap {
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(postCommentCrudService.insertPostComment(it), PostCommentVo::class.java)
                    }.switchIfEmpty(Mono.error(InvalidParameterException("request body is not exist")))

    fun updatePostComment(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(UpdatePostCommentVo::class.java)
                    .flatMap {
                        ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(postCommentCrudService.updatePostComment(it), PostCommentVo::class.java)
                    }.switchIfEmpty(Mono.error(InvalidParameterException("request body is not exist")))

    fun deletePostComment(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(postCommentCrudService.deletePostComment(
                            id = request.queryParam("id")
                                    .orElseThrow { IllegalArgumentException("id is not exist") },
                            password = request.queryParam("id")
                                    .orElseThrow { IllegalArgumentException("password is not exist") }
                    ), Void::class.java)

    fun findPostCommentWithPaging(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                            postCommentCrudService.getPostCommentsByPostIdWithPaging(
                                    pageable = pageUtil.makePageRequest(request),
                                    postId = request.queryParam("postId")
                                            .orElseThrow { IllegalArgumentException("postId is not exist") }
                            ), PaginatedObject::class.java
                    )
}