package org.jeong.reservationinformation.community.service

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Mono

interface PostSearchService {
    fun findPostsAllWithPaging(pageable: Pageable): Mono<PaginatedObject<PostVo>>
    fun findPostsByTitleLikeAndCategoryWithPaging(pageable: Pageable, title: String, category: PostCategory)
    fun findPostsByContentLikeAndCategoryWithPaging(pageable: Pageable, content: String, category: PostCategory)
    fun findPostsByUserNameLikeAndCategoryWithPaging(pageable: Pageable, userName: String, category: PostCategory)
}