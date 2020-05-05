package org.jeong.reservationinformation.community.repository

import org.jeong.reservationinformation.community.domain.document.Post
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface PostRepository : ReactiveMongoRepository<Post, String> {
    fun findByIdNotNull(pageable: Pageable): Flux<Post>

    fun findAllByPostCategory(pageable: Pageable, postCategory: PostCategory): Flux<Post>

    fun countAllByPostCategory(postCategory: PostCategory): Mono<Long>

    fun findAllByContentLikeAndPostCategory(pageable: Pageable, searchKeyword: String, postCategory: PostCategory)
            : Flux<Post>

    fun countAllByContentLikeAndPostCategory(searchKeyword: String, postCategory: PostCategory)
            : Mono<Long>

    fun findAllByTitleLikeAndPostCategory(pageable: Pageable, searchKeyword: String, postCategory: PostCategory)
            : Flux<Post>

    fun countAllByTitleLikeAndPostCategory(searchKeyword: String, postCategory: PostCategory)
            : Mono<Long>

    fun findAllByUsernameLikeAndPostCategory(pageable: Pageable, searchKeyword: String, postCategory: PostCategory)
            : Flux<Post>

    fun countAllByUsernameLikeAndPostCategory(searchKeyword: String, postCategory: PostCategory)
            : Mono<Long>
}