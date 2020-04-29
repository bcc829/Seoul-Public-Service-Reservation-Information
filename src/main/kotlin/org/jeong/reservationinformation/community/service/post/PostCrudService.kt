package org.jeong.reservationinformation.community.service.post

import org.jeong.reservationinformation.community.domain.vo.InsertPostVo
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostVo
import reactor.core.publisher.Mono

interface PostCrudService {
    fun insertPost(insertPostVo: InsertPostVo): Mono<PostVo>
    fun updatePost(updatePostVo: UpdatePostVo): Mono<PostVo>
    fun deletePost(id: String, password: String): Mono<Void>
    fun getPost(id: String): Mono<PostVo>
}