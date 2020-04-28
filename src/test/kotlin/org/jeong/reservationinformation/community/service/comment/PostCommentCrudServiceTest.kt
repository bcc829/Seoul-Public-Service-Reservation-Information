package org.jeong.reservationinformation.community.service.comment

import org.jeong.reservationinformation.community.domain.document.PostComment
import org.jeong.reservationinformation.community.domain.vo.InsertPostCommentVo
import org.jeong.reservationinformation.community.domain.vo.UpdatePostCommentVo
import org.jeong.reservationinformation.community.repository.PostCommentRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier

@SpringBootTest
class PostCommentCrudServiceTest {

    @Autowired
    lateinit var postCommentCrudService: PostCommentCrudService

    @Autowired
    lateinit var postCommentRepository: PostCommentRepository

    @BeforeEach
    fun beforeTest() {
        postCommentRepository.deleteAll().block()

        postCommentRepository.save(
                PostComment(
                        postId = "testPost",
                        password = "test",
                        userName = "tester",
                        comment = "test comment"
                )
        ).block()

        postCommentRepository.save(
                PostComment(
                        postId = "testPost",
                        password = "test",
                        userName = "테스터",
                        comment = "테스트 댓글"
                )
        ).block()

        postCommentRepository.save(
                PostComment(
                        postId = "testPost",
                        password = "test",
                        userName = "테스터2",
                        comment = "댓글"
                )
        ).block()

    }

    @Test
    fun insertPostCommentTest() {
        postCommentCrudService.insertPostComment(
                insertPostCommentVo = InsertPostCommentVo(
                        postId = "testPost",
                        password = "test",
                        userName = "Junit",
                        comment = "junit test"
                )
        ).block()

        val data = postCommentRepository.count()

        StepVerifier
                .create(data)
                .expectNext(4)
                .verifyComplete()
    }

    @Test
    fun updatePostCommentTest() {
        val postCommentVo = postCommentCrudService.insertPostComment(
                insertPostCommentVo = InsertPostCommentVo(
                        postId = "testPost",
                        password = "test",
                        userName = "Junit",
                        comment = "junit test"
                )
        ).block()!!

        postCommentCrudService.updatePostComment(
                updatePostCommentVo = UpdatePostCommentVo(
                        id = postCommentVo.id,
                        comment = "update test",
                        password = "test"
                )
        ).block()

        val data = postCommentRepository.findById(postCommentVo.id)

        StepVerifier
                .create(data)
                .expectNextMatches { it.comment == "update test" }
                .verifyComplete()
    }

    @Test
    fun deletePostCommentTest() {
        val postComment = postCommentRepository.save(
                PostComment(
                        postId = "testPost",
                        password = "test",
                        userName = "테스터3",
                        comment = "댓글"
                )
        ).block()!!

        postCommentCrudService.deletePostComment(postComment.id!!).block()

        val data = postCommentRepository.count()

        StepVerifier
                .create(data)
                .expectNext(3)
                .verifyComplete()
    }
    
    @Test
    fun getPostCommentsByPostIdWithPagingTest() {
        val pageRequest = PageRequest.of(0, 2, Sort.by("registerDate").descending())
        
        val data = postCommentCrudService
                .getPostCommentsByPostIdWithPaging(pageRequest, "testPost")
        
        StepVerifier
                .create(data)
                .expectNextMatches { 
                    it.pageInfo.totalCount == 3L && it.pageInfo.numberOfElements == 2
                            && it.content[0].comment == "댓글" && it.content[1].comment == "테스트 댓글"
                }
    }
}