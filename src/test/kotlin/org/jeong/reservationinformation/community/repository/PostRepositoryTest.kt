package org.jeong.reservationinformation.community.repository

import org.jeong.reservationinformation.community.domain.document.Post
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    lateinit var postRepository: PostRepository

    @BeforeEach
    fun beforeTest() {
        postRepository.deleteAll().block()

        postRepository.save(Post(
                username = "tester",
                password = "test",
                content = "test contents",
                title = "title!",
                postCategory = PostCategory.SOCCER
        )).block()

        postRepository.save(Post(
                username = "tester",
                password = "test",
                content = "test contents2",
                title = "title2!",
                postCategory = PostCategory.SOCCER
        )).block()!!

        postRepository.save(Post(
                username = "manager",
                password = "test",
                content = "manager contents2",
                title = "manager!",
                postCategory = PostCategory.SOCCER
        )).block()!!

    }

    @Test
    fun findAllByContentLikeTest() {

        val pageRequest = PageRequest.of(0, 10, Sort.by("registerDate").descending())

        val data = postRepository
                .findAllByContentLikeAndPostCategory(pageRequest, "test", PostCategory.SOCCER)

        StepVerifier
                .create(data)
                .expectNextMatches { it.content == "test contents2" }
                .expectNextMatches { it.content == "test contents" }
                .verifyComplete()

    }

    @Test
    fun findAllByTitleLikeTest() {

        val pageRequest = PageRequest.of(0, 10, Sort.by("registerDate").descending())

        val data = postRepository
                .findAllByTitleLikeAndPostCategory(pageRequest, "manager", PostCategory.SOCCER)

        StepVerifier
                .create(data)
                .expectNextMatches { it.content == "manager contents2" }
                .verifyComplete()

    }

    @Test
    fun findAllByUserNameLikeTest() {
        val pageRequest = PageRequest.of(0, 10, Sort.by("registerDate").descending())

        val data = postRepository
                .findAllByUsernameLikeAndPostCategory(pageRequest, "manager", PostCategory.SOCCER)

        StepVerifier
                .create(data)
                .expectNextMatches { it.content == "manager contents2" }
                .verifyComplete()

    }

}