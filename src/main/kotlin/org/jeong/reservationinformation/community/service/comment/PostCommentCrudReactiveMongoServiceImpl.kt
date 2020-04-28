package org.jeong.reservationinformation.community.service.comment

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.community.domain.vo.InsertPostCommentVo
import org.jeong.reservationinformation.community.domain.vo.PostCommentVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostCommentVo
import org.jeong.reservationinformation.community.repository.PostCommentRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PostCommentCrudReactiveMongoServiceImpl(
        val postCommentRepository: PostCommentRepository,
        val pageUtil: PageUtil
) : PostCommentCrudService {
    override fun insertPostComment(insertPostCommentVo: InsertPostCommentVo): Mono<PostCommentVo> =
            postCommentRepository.save(insertPostCommentVo.toPostComment())
                    .map { it.toPostCommentVo() }


    override fun updatePostComment(updatePostCommentVo: UpdatePostCommentVo): Mono<PostCommentVo> =
            postCommentRepository.findById(updatePostCommentVo.id)
                    .flatMap {
                        if(it.password == updatePostCommentVo.password) {
                            it.comment = updatePostCommentVo.comment
                            postCommentRepository.save(it)
                        } else {
                            Mono.error(IllegalAccessException("password is not matching"))
                        }
                    }.map {
                        it.toPostCommentVo()
                    }.switchIfEmpty(Mono.error(NoSuchElementException("${updatePostCommentVo.id} is not exist")))

    override fun deletePostComment(id: String): Mono<Void> =
            postCommentRepository.deleteById(id)

    override fun getPostCommentsByPostIdWithPaging(pageable: Pageable, postId: String): Mono<PaginatedObject<PostCommentVo>> {
        val totalCount = postCommentRepository.countAllByPostId(postId)
        val postComments = postCommentRepository.findAllByPostId(pageable, postId)
                .map { it.toPostCommentVo() }
                .collectList()

        return pageUtil.makePagingObjectPublisher(
                pageable = pageable,
                monoPageContents = postComments,
                monoTotalCount = totalCount
        )
    }
}