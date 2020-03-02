package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.reservation.sport.enum.SportCategory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import reactor.test.StepVerifier

@SpringBootTest
@TestPropertySource(properties = ["api.key = sample"])
class GetReservationServiceTest {

    @Autowired
    lateinit var getReservationService: GetReservationService

    @Test
    fun getReservationListWithPageCategoryAllTest() {
        val sportCategory = SportCategory.ALL
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.size == 5 }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryBadmintonCourtTest() {
        val sportCategory = SportCategory.BADMINTON_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryBaseballCourtTest() {
        val sportCategory = SportCategory.BASEBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryBasketballCourtTest() {
        val sportCategory = SportCategory.BASKETBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }


    @Test
    fun getReservationListWithPageCategoryFootballCourtTest() {
        val sportCategory = SportCategory.FOOTBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryFutsalTest() {
        val sportCategory = SportCategory.FUTSAL
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryFutsalStadiumTest() {
        val sportCategory = SportCategory.FUTSAL_STADIUM
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryGymTest() {
        val sportCategory = SportCategory.GYM
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryMultiPurposeStadiumTest() {
        val sportCategory = SportCategory.MULTIPURPOSE_STADIUM
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryParkGolfCourseTest() {
        val sportCategory = SportCategory.PARK_GOLF_COURSE
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryPlaygroundTest() {
        val sportCategory = SportCategory.PLAYGROUND
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryTableTennisCourtTest() {
        val sportCategory = SportCategory.TABLE_TENNIS_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryTennisCourtTest() {
        val sportCategory = SportCategory.TENNIS_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationListWithPageCategoryVolleyballCourtTest() {
        val sportCategory = SportCategory.VOLLEYBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getReservationService.getReservationListWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }
}