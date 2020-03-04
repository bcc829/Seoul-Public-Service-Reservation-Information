package org.jeong.reservationinformation.reservation.culture.repository

import org.jeong.reservationinformation.reservation.culture.domian.document.CultureReservationComment
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
@TestPropertySource(properties = ["api.key = sample"])
class CultureReservationCommentReactiveRepositoryTest {

    @Autowired
    lateinit var cultureReservationCommentReactiveRepository: CultureReservationCommentReactiveRepository

    @BeforeEach
    fun beforeTest() {
        cultureReservationCommentReactiveRepository.deleteAll().block()
    }

    @Test
    fun cultureReservationCommentReactiveRepositorySaveTest() {
        val data = cultureReservationCommentReactiveRepository
                .save(CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
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
    fun cultureReservationCommentReactiveRepositoryFindBySportReservationSvcIdTest() {
        cultureReservationCommentReactiveRepository
                .save(CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
                        comment = "test comment1",
                        password = "password",
                        rating = 3,
                        userName = "tester"
                )).block()

        cultureReservationCommentReactiveRepository
                .save(CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
                        comment = "test comment2",
                        password = "password",
                        rating = 3,
                        userName = "tester"
                )).block()

        val findData = cultureReservationCommentReactiveRepository
                .findByCultureReservationSvcId("testSvcId")

        StepVerifier
                .create(findData)
                .assertNext {
                    assertEquals(it.cultureReservationSvcId, "testSvcId")
                    assertEquals("test comment1", it.comment)
                }
                .assertNext {
                    assertEquals(it.cultureReservationSvcId, "testSvcId")
                    assertEquals("test comment2", it.comment)
                }
                .verifyComplete()
    }

}