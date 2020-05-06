package org.jeong.reservationinformation.reservation.culture.service

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.culture.domian.document.CultureReservationComment
import org.jeong.reservationinformation.reservation.culture.repository.CultureReservationCommentReactiveRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier

@SpringBootTest
class CultureReservationCommentCrudServiceTest {

    @Autowired
    lateinit var cultureReservationCommentCrudService: CultureReservationCommentCrudService

    @Autowired
    lateinit var cultureReservationCommentReactiveRepository: CultureReservationCommentReactiveRepository

    @BeforeEach
    fun beforeTest() {
        cultureReservationCommentReactiveRepository.deleteAll().block()
    }

    @Test
    fun insertSportReservationCommentTest() {

        val data = cultureReservationCommentCrudService
                .insertCultureReservationComment(InsertReservationCommentVo(
                        svcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                ))

        StepVerifier
                .create(data)
                .assertNext {
                    assertEquals("testSvcId", it.svcId)
                    assertEquals("testComment", it.comment)
                }
                .verifyComplete()

    }

    @Test
    fun getSportReservationCommentBySvcIdTest() {

        cultureReservationCommentReactiveRepository.save(
                CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        val pageRequest = PageRequest.of(0, 1, Sort.by("registerDate").descending())

        val data = cultureReservationCommentCrudService
                .getCultureReservationCommentBySvcIdWithPaging(pageRequest, "testSvcId")

        StepVerifier.create(data)
                .assertNext {
                    assertEquals(1, it.pageInfo.numberOfElements)
                    assertEquals("testSvcId", it.content[0].svcId)
                    assertEquals("testComment", it.content[0].comment)
                }
                .verifyComplete()
    }

    @Test
    fun updateSportReservationComment() {

        cultureReservationCommentReactiveRepository.save(
                CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        val comment = cultureReservationCommentReactiveRepository
                .findAll().blockFirst()!!

        val data = cultureReservationCommentCrudService
                .updateCultureReservationComment(UpdateReservationCommentVo(
                        id = comment.id!!,
                        password = comment.password,
                        rating = 5,
                        comment = "update comment"
                ))

        StepVerifier.create(data)
                .assertNext {
                    assertEquals(5, it.rating)
                    assertEquals("update comment", it.comment)
                }
                .verifyComplete()
    }

    @Test
    fun updateNotExistSportReservationComment() {

        val data = cultureReservationCommentCrudService
                .updateCultureReservationComment(UpdateReservationCommentVo(
                        id = "231",
                        password = "pass",
                        rating = 5,
                        comment = "update comment"
                ))

        StepVerifier.create(data)
                .verifyError(NoSuchElementException::class.java)
    }

    @Test
    fun updatePasswordNotMatchingSportReservationComment() {

        cultureReservationCommentReactiveRepository.save(
                CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        val comment = cultureReservationCommentReactiveRepository
                .findAll().blockFirst()!!

        val data = cultureReservationCommentCrudService
                .updateCultureReservationComment(UpdateReservationCommentVo(
                        id = comment.id!!,
                        password = "not match",
                        rating = 5,
                        comment = "update comment"
                ))

        StepVerifier.create(data)
                .verifyError(IllegalAccessException::class.java)
    }

    @Test
    fun deleteSportReservationCommentTest() {

        val comment = cultureReservationCommentReactiveRepository.save(
                CultureReservationComment(
                        cultureReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        if (comment != null) {
            cultureReservationCommentCrudService.deleteCultureReservationComment(comment.id!!, comment.password).block()
        }

        val comments = cultureReservationCommentReactiveRepository.count()

        StepVerifier
                .create(comments)
                .assertNext {
                    assertEquals(0, it)
                }
                .verifyComplete()
    }


}