package org.jeong.reservationinformation.community.service.post

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.PostVo
import org.jeong.reservationinformation.community.repository.PostRepository
import org.jeong.reservationinformation.community.service.post.PostSearchService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PostSearchReactiveMongoServiceImpl(val postRepository: PostRepository,
                                         val pageUtil: PageUtil) : PostSearchService {

    override fun findPostsAllWithPaging(pageable: Pageable): Mono<PaginatedObject<PostVo>> =
            pageUtil.makePagingObjectPublisher(
                    pageable = pageable,
                    monoTotalCount = postRepository.count(),
                    monoPageContents = postRepository
                            .findByIdNotNull(pageable)
                            .map { it.toPostVo() }
                            .collectList()
            )

    override fun findPostsByCategoryWithPaging(pageable: Pageable, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>> =
        pageUtil.makePagingObjectPublisher(
                pageable = pageable,
                monoTotalCount = postRepository.countAllByPostCategory(postCategory),
                monoPageContents = postRepository
                        .findAllByPostCategory(pageable, postCategory)
                        .map { it.toPostVo() }
                        .collectList()
        )


    override fun findPostsByTitleLikeAndCategoryWithPaging(pageable: Pageable, title: String, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>> =
            pageUtil.makePagingObjectPublisher(
                    pageable = pageable,
                    monoTotalCount = postRepository.countAllByTitleLikeAndPostCategory(title, postCategory),
                    monoPageContents = postRepository
                            .findAllByTitleLikeAndPostCategory(
                                    pageable = pageable,
                                    searchKeyword = title,
                                    postCategory = postCategory
                            )
                            .map { it.toPostVo() }
                            .collectList()
            )


    override fun findPostsByContentLikeAndCategoryWithPaging(pageable: Pageable, content: String, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>> =
            pageUtil.makePagingObjectPublisher(
                    pageable = pageable,
                    monoTotalCount = postRepository.countAllByContentLikeAndPostCategory(content, postCategory),
                    monoPageContents = postRepository
                            .findAllByContentLikeAndPostCategory(
                                    pageable = pageable,
                                    searchKeyword = content,
                                    postCategory = postCategory
                            )
                            .map { it.toPostVo() }
                            .collectList()
            )

    override fun findPostsByUserNameLikeAndCategoryWithPaging(pageable: Pageable, userName: String, postCategory: PostCategory)
            : Mono<PaginatedObject<PostVo>> =
            pageUtil.makePagingObjectPublisher(
                    pageable = pageable,
                    monoTotalCount = postRepository.countAllByUserNameLikeAndPostCategory(userName, postCategory),
                    monoPageContents = postRepository
                            .findAllByUserNameLikeAndPostCategory(
                                    pageable = pageable,
                                    searchKeyword = userName,
                                    postCategory = postCategory
                            )
                            .map { it.toPostVo() }
                            .collectList()
            )
}