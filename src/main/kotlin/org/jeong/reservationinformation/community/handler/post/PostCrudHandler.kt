package org.jeong.reservationinformation.community.handler.post

import org.jeong.reservationinformation.community.domain.vo.InsertPostVo
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostVo
import org.jeong.reservationinformation.community.service.post.PostCrudService
import org.jeong.reservationinformation.community.service.post.PostSearchService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.security.InvalidParameterException

@Component
class PostCrudHandler(val postCrudService: PostCrudService, val postSearchService: PostSearchService) {

    fun insertPost(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(InsertPostVo::class.java)
                    .flatMap {
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(postCrudService.insertPost(it), PostVo::class.java)
                    }.switchIfEmpty(Mono.error(InvalidParameterException("request body is not exist")))

    fun updatePost(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(UpdatePostVo::class.java)
                    .flatMap {
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(postCrudService.updatePost(it), PostVo::class.java)
                    }.switchIfEmpty(Mono.error(InvalidParameterException("request body is not exist")))

    fun deletePost(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(postCrudService.deletePost(
                            id = request.queryParam("id")
                                    .orElseThrow { IllegalArgumentException("id is not exist") },
                            password = request.queryParam("id")
                                    .orElseThrow { IllegalArgumentException("password is not exist") }
                            ), Void::class.java)

    fun getPost(request: ServerRequest): Mono<ServerResponse> =
            ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(postCrudService.getPost(
                            id = request.queryParam("id")
                                    .orElseThrow { IllegalArgumentException("id is not exist") }
                    ),PostVo::class.java)

}
