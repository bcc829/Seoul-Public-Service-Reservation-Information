package org.jeong.reservationinformation.community.service

import org.jeong.reservationinformation.community.domain.vo.InsertPostVo
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostVo
import reactor.core.publisher.Mono
import java.awt.print.Pageable

interface PostCRUDService {
    fun insertPost(insertPostVo: InsertPostVo): Mono<PostVo>
    fun updatePost(updatePostVo: UpdatePostVo): Mono<PostVo>
    fun deletePost(id: String): Mono<Void>
    fun getPostsWithPaging(pageable: Pageable)
}