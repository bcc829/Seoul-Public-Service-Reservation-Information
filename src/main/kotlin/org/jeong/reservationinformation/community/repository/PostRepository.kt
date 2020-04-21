package org.jeong.reservationinformation.community.repository

import org.jeong.reservationinformation.community.domain.document.Post
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface PostRepository : ReactiveMongoRepository<Post, String> {
    fun findByIdNotNull(pageable: Pageable): Flux<Post>

    fun findAllByContentLikeAndPostCategory(pageable: Pageable, searchKeyword: String, category: PostCategory)
            : Flux<Post>

    fun findAllByTitleLikeAndPostCategory(pageable: Pageable, searchKeyword: String, category: PostCategory)
            : Flux<Post>

    fun findAllByUserNameLikeAndPostCategory(pageable: Pageable, searchKeyword: String, postCategory: PostCategory)
            : Flux<Post>
}