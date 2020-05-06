package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.jeong.reservationinformation.reservation.sport.repository.SportReservationCommentReactiveRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier

@SpringBootTest
class SportReservationCommentCrudServiceTest {

    @Autowired
    lateinit var sportReservationCommentCrudService: SportReservationCommentCrudService

    @Autowired
    lateinit var sportReservationCommentReactiveRepository: SportReservationCommentReactiveRepository

    @BeforeEach
    fun beforeTest() {
        sportReservationCommentReactiveRepository.deleteAll().block()
    }

    @Test
    fun insertSportReservationCommentTest() {

        val data = sportReservationCommentCrudService
                .insertSportReservationComment(InsertReservationCommentVo(
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

        sportReservationCommentReactiveRepository.save(
                SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        val pageRequest = PageRequest.of(0, 13, Sort.by("registerDate").descending())

        val data = sportReservationCommentCrudService
                .getSportReservationCommentBySvcIdWithPaging(pageRequest, "testSvcId")

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

        sportReservationCommentReactiveRepository.save(
                SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        val comment = sportReservationCommentReactiveRepository
                .findAll().blockFirst()!!

        val data = sportReservationCommentCrudService
                .updateSportReservationComment(UpdateReservationCommentVo(
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

        val data = sportReservationCommentCrudService
                .updateSportReservationComment(UpdateReservationCommentVo(
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

        sportReservationCommentReactiveRepository.save(
                SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        val comment = sportReservationCommentReactiveRepository
                .findAll().blockFirst()!!

        val data = sportReservationCommentCrudService
                .updateSportReservationComment(UpdateReservationCommentVo(
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

        val comment = sportReservationCommentReactiveRepository.save(
                SportReservationComment(
                        sportReservationSvcId = "testSvcId",
                        comment = "testComment",
                        rating = 3,
                        userName = "test",
                        password = "mypass"
                )
        ).block()

        if (comment != null) {
            sportReservationCommentCrudService.deleteSportReservationComment(comment.id!!, comment.password).block()
        }

        val comments = sportReservationCommentReactiveRepository.count()

        StepVerifier
                .create(comments)
                .assertNext {
                    assertEquals(0, it)
                }
                .verifyComplete()
    }


}