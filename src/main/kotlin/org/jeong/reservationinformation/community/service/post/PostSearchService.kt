package org.jeong.reservationinformation.community.service.post

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Mono

interface PostSearchService {
    fun findPostsAllWithPaging(pageable: Pageable): Mono<PaginatedObject<PostVo>>
    fun findPostsByCategory(pageable: Pageable, postCategory: PostCategory): Mono<PaginatedObject<PostVo>>
    fun findPostsByTitleLikeAndCategoryWithPaging(pageable: Pageable, title: String, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>>
    fun findPostsByContentLikeAndCategoryWithPaging(pageable: Pageable, content: String, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>>
    fun findPostsByUserNameLikeAndCategoryWithPaging(pageable: Pageable, userName: String, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>>
}