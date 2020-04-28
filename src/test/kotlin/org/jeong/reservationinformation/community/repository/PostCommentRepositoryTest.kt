package org.jeong.reservationinformation.community.repository

import org.jeong.reservationinformation.community.domain.document.PostComment
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier

@SpringBootTest
class PostCommentRepositoryTest {

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
    fun findAllByPostIdTest() {
        val pageRequest = PageRequest.of(0, 10, Sort.by("registerDate").descending())

        val data = postCommentRepository.findAllByPostId(pageRequest, "testPost")

        StepVerifier
                .create(data)
                .expectNextMatches { it.userName == "테스터2" }
                .expectNextMatches { it.userName == "테스터" }
                .expectNextMatches { it.userName == "tester" }
                .verifyComplete()
    }

}