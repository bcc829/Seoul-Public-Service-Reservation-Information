package org.jeong.reservationinformation.community.service

import org.jeong.reservationinformation.common.domain.PageInfo
import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.community.domain.vo.InsertPostVo
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostVo
import org.jeong.reservationinformation.community.repository.PostRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PostCrudServiceReactiveMongoServiceImpl(val postRepository: PostRepository,
                                              val pageUtil: PageUtil) : PostCrudService {
    override fun insertPost(insertPostVo: InsertPostVo): Mono<PostVo> =
            postRepository.save(insertPostVo.toPost())
                    .map { it.toPostVo() }


    override fun updatePost(updatePostVo: UpdatePostVo): Mono<PostVo> =
            postRepository.findById(updatePostVo.id)
                    .flatMap {
                        if (it.password == updatePostVo.password) {
                            it.content = updatePostVo.content
                            it.title = updatePostVo.title

                            postRepository.save(it)
                        } else {
                            Mono.error(IllegalAccessException("password is not matching"))
                        }
                    }.map {
                        it.toPostVo()
                    }.switchIfEmpty(Mono.error(NoSuchElementException("${updatePostVo.id} is not exist")))

    override fun deletePost(id: String): Mono<Void> =
            postRepository.deleteById(id)

    override fun getPost(id: String): Mono<PostVo> =
            postRepository.findById(id)
                    .flatMap {
                        it.viewCount = it.viewCount?.plus(1)

                        postRepository.save(it)
                    }.map {
                        it.toPostVo()
                    }.switchIfEmpty(Mono.error(NoSuchElementException("$id is not exist")))

    override fun getPostsWithPaging(pageable: Pageable): Mono<PaginatedObject<PostVo>> {
        val totalCountMono = postRepository.count()
        val postsWithPaging = postRepository.findByIdNotNull(pageable).collectList()

        return Mono.zip(totalCountMono, postsWithPaging)
                .map {
                    val lastPage = pageUtil.getLastPage(it.t1, pageable.pageSize)

                    PaginatedObject(
                            pageInfo = PageInfo(
                                    totalCount = it.t1,
                                    isLast = lastPage == pageable.pageNumber,
                                    isFirst = pageable.pageNumber == 1,
                                    firstPage = 1,
                                    lastPage = lastPage,
                                    hasNext = pageable.pageNumber < lastPage,
                                    numberOfElements = it.t2.size
                            ),
                            content = it.t2.map { post -> post.toPostVo() }
                    )
                }
    }


}