package org.jeong.reservationinformation.community.service

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.community.domain.vo.InsertPostCommentVo
import org.jeong.reservationinformation.community.domain.vo.PostCommentVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostCommentVo
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Mono

interface PostCommentCrudService {
    fun insertPostComment(insertPostCommentVo: InsertPostCommentVo): Mono<PostCommentVo>
    fun updatePostComment(updatePostCommentVo: UpdatePostCommentVo): Mono<PostCommentVo>
    fun deletePostComment(id: String): Mono<Void>
    fun getPostCommentWithPaging(pageable: Pageable): Mono<PaginatedObject<PostCommentVo>>
}