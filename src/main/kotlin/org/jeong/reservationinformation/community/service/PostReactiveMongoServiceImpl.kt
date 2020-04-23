package org.jeong.reservationinformation.community.service

import org.jeong.reservationinformation.common.domain.PageInfo
import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.repository.PostRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PostReactiveMongoServiceImpl(val postRepository: PostRepository,
                                   val pageUtil: PageUtil) : PostSearchService {

    override fun findPostsAllWithPaging(pageable: Pageable): Mono<PaginatedObject<PostVo>> {
        val totalCountMono = postRepository.count()
        val postsWithPaging =
                postRepository
                        .findByIdNotNull(pageable)
                        .map { it.toPostVo() }
                        .collectList()

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
                            content = it.t2
                    )
                }
    }


    override fun findPostsByTitleLikeAndCategoryWithPaging(pageable: Pageable, title: String, category: PostCategory) {
        TODO("Not yet implemented")
    }

    override fun findPostsByContentLikeAndCategoryWithPaging(pageable: Pageable, content: String, category: PostCategory) {
        TODO("Not yet implemented")
    }

    override fun findPostsByUserNameLikeAndCategoryWithPaging(pageable: Pageable, userName: String, category: PostCategory) {
        TODO("Not yet implemented")
    }
}