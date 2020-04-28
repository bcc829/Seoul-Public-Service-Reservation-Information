package org.jeong.reservationinformation.community.repository

import org.jeong.reservationinformation.community.domain.document.PostComment
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface PostCommentRepository : ReactiveMongoRepository<PostComment, String> {
    fun findAllByPostId(pageable: Pageable, postId: String): Flux<PostComment>
    fun countAllByPostId(postId: String): Mono<Long>
}