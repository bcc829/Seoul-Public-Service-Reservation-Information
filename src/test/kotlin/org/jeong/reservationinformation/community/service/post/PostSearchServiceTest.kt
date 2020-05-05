package org.jeong.reservationinformation.community.service.post

import org.jeong.reservationinformation.community.domain.document.Post
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.repository.PostRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier

@SpringBootTest
class PostSearchServiceTest {

    @Autowired
    lateinit var postSearchService: PostSearchService

    @Autowired
    lateinit var postRepository: PostRepository

    val pageRequest = PageRequest.of(0, 3, Sort.by("registerDate").descending())

    @BeforeEach
    fun beforeTest() {
        postRepository.deleteAll().block()

        postRepository.save(
                Post(
                        content = "난 사과 좋아함",
                        title = "사과 좋아함",
                        username = "apple",
                        postCategory = PostCategory.SOCCER,
                        password = "test124"
                )
        ).block()

        postRepository.save(
                Post(
                        content = "난 사과 싫어함",
                        title = "사과 싫어함",
                        username = "banana",
                        postCategory = PostCategory.SOCCER,
                        password = "test124"
                )
        ).block()

        postRepository.save(
                Post(
                        content = "포도",
                        title = "포도 좋아함",
                        username = "grape",
                        postCategory = PostCategory.SOCCER,
                        password = "test124"
                )
        ).block()

        postRepository.save(
                Post(
                        content = "농구임",
                        title = "농구 ㅋㅋ",
                        username = "basketman",
                        postCategory = PostCategory.BASKETBALL,
                        password = "test124"
                )
        ).block()

    }

   @Test
    fun findPostsAllWithPagingTest() {

        val data = postSearchService.findPostsAllWithPaging(pageRequest)

        StepVerifier
                .create(data)
                .expectNextMatches {
                    it.content[0].title == "농구 ㅋㅋ"  && it.content[1].title == "포도 좋아함" &&
                            it.content[2].title == "사과 싫어함" && it.pageInfo.hasNext &&
                            it.pageInfo.numberOfElements == 3 && it.pageInfo.isFirst && !it.pageInfo.isLast
                }.verifyComplete()
    }

    @Test
    fun findPostsByCategoryWithPagingTest() {
        val data = postSearchService.findPostsByCategoryWithPaging(pageRequest, PostCategory.SOCCER)

        StepVerifier
                .create(data)
                .expectNextMatches {
                    it.content[0].title == "포도 좋아함" &&
                            it.content[1].title == "사과 싫어함" && !it.pageInfo.hasNext &&
                            it.pageInfo.numberOfElements == 3 && it.pageInfo.isFirst && it.pageInfo.isLast
                }

    }

    @Test
    fun findPostsByTitleLikeAndCategoryWithPaging() {
        val title = "사과"

        val data = postSearchService.findPostsByTitleLikeAndCategoryWithPaging(
                pageRequest,
                title,
                PostCategory.SOCCER
        )

        StepVerifier
                .create(data)
                .expectNextMatches {
                    it.content[0].title == "사과 싫어함" && it.content[1].title == "사과 좋아함" &&
                            !it.pageInfo.hasNext && it.pageInfo.numberOfElements == 2 && it.pageInfo.isFirst
                            && it.pageInfo.isLast
                }
    }

    @Test
    fun findPostsByContentLikeAndCategoryWithPaging() {
        val content = "포도"

        val data = postSearchService.findPostsByContentLikeAndCategoryWithPaging(
                pageRequest,
                content,
                PostCategory.SOCCER
        )

        StepVerifier
                .create(data)
                .expectNextMatches {
                    it.content[0].title == "포도 좋아함" && it.pageInfo.totalCount == 1L
                }
    }

    @Test
    fun findPostsByUserNameLikeAndCategoryWithPagingTest() {
        val userName = "appl"

        val data = postSearchService.findPostsByUserNameLikeAndCategoryWithPaging(
                pageRequest,
                userName,
                PostCategory.SOCCER
        )

        StepVerifier
                .create(data)
                .expectNextMatches {
                    it.content[0].title == "사과 좋아함" && it.pageInfo.totalCount == 1L
                }

    }
}