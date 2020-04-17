package org.jeong.reservationinformation.reservation.sport.repository

import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import reactor.test.StepVerifier

@SpringBootTest
class SportReservationCommentReactiveRepositoryTest {

    @Autowired
    lateinit var sportReservationCommentReactiveRepository: SportReservationCommentReactiveRepository

    @BeforeEach
    fun beforeTest() {
        sportReservationCommentReactiveRepository.deleteAll().block()
    }

    @Test
    fun sportReservationCommentReactiveRepositorySaveTest() {
        val data = sportReservationCommentReactiveRepository
                .save(SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "test comment",
                        password = "password",
                        rating = 3,
                        userName = "tester"
                ))

        StepVerifier
                .create(data)
                .assertNext {
                    assertEquals("password", it.password)
                    assertEquals("test comment", it.comment)
                }
                .verifyComplete()
    }

    @Test
    fun sportReservationCommentReactiveRepositoryFindBySportReservationSvcIdOrderByRegisterDateDesc() {
        sportReservationCommentReactiveRepository
                .save(SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "test comment1",
                        password = "password",
                        rating = 3,
                        userName = "tester"
                )).block()

        sportReservationCommentReactiveRepository
                .save(SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "test comment2",
                        password = "password",
                        rating = 3,
                        userName = "tester"
                )).block()

        val findData = sportReservationCommentReactiveRepository
                .findBySportReservationSvcIdOrderByRegisterDateDesc("testSvcId")

        StepVerifier
                .create(findData)
                .assertNext {
                    assertEquals(it.sportReservationSvcId, "testSvcId")
                    assertEquals("test comment2", it.comment)
                }
                .assertNext {
                    assertEquals(it.sportReservationSvcId, "testSvcId")
                    assertEquals("test comment1", it.comment)
                }
                .verifyComplete()

    }

}