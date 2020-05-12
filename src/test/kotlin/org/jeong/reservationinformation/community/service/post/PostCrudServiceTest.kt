package org.jeong.reservationinformation.community.service.post

import org.jeong.reservationinformation.community.domain.document.Post
import org.jeong.reservationinformation.community.domain.enums.PostCategory
import org.jeong.reservationinformation.community.domain.vo.InsertPostVo
import org.jeong.reservationinformation.community.repository.PostRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier

@SpringBootTest
class PostCrudServiceTest {

    @Autowired
    lateinit var postCrudService: PostCrudService

    @Autowired
    lateinit var postRepository: PostRepository

    @BeforeEach
    fun beforeTest() {

        postRepository.deleteAll().block()

        postRepository.save(
                Post(
                        content = "test1243",
                        title = "test title",
                        username = "tester",
                        postCategory = PostCategory.SOCCER,
                        password = "test124"
                )
        ).block()

        postRepository.save(
                Post(
                        content = "test123",
                        title = "test title",
                        username = "tester1",
                        postCategory = PostCategory.SOCCER,
                        password = "test124"
                )
        ).block()

        postRepository.save(
                Post(
                        content = "test1232",
                        title = "test title",
                        username = "tester2",
                        postCategory = PostCategory.SOCCER,
                        password = "test124"
                )
        ).block()

    }

    @Test
    fun insertPostTest() {
        postCrudService.insertPost(InsertPostVo(
                content = "test1232",
                title = "test title",
                username = "tester2",
                postCategory = PostCategory.SOCCER,
                password = "test124"
        )).block()

        val data = postRepository.count()

        StepVerifier
                .create(data)
                .expectNext(4)
                .verifyComplete()

    }

    @Test
    fun deletePostTest() {
        val post = postCrudService.insertPost(InsertPostVo(
                content = "test1232",
                title = "test title",
                username = "tester2",
                postCategory = PostCategory.SOCCER,
                password = "test124"
        )).block()!!

        postCrudService.deletePost(post.id, "test124").block()

        val data = postRepository.count()

        StepVerifier
                .create(data)
                .expectNext(3)
                .verifyComplete()
    }

    @Test
    fun getPostTest() {
        val id = postCrudService.insertPost(InsertPostVo(
                content = "test1232",
                title = "test title",
                username = "tester2",
                postCategory = PostCategory.SOCCER,
                password = "test124"
        )).block()!!.id

        val data = postCrudService.getPost(id)

        StepVerifier
                .create(data)
                .expectNextMatches { it.title == "test title" && it.viewCount == 1 }
                .verifyComplete()
    }

    @Test
    fun getPostNoDataTest() {

        val data = postCrudService.getPost("no suchId")

        StepVerifier
                .create(data)
                .verifyError(NoSuchElementException::class.java)
    }

}