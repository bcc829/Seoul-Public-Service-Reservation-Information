package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.reservation.sport.domain.enums.SportCategory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier

@SpringBootTest
class GetSportReservationServiceTest {

    @Autowired
    lateinit var getSportReservationService: GetSportReservationService

    @Test
    fun getReservationsWithPageCategoryAllTest() {
        val sportCategory = SportCategory.ALL
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.size == 5 }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryBadmintonCourtTest() {
        val sportCategory = SportCategory.BADMINTON_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryBaseballCourtTest() {
        val sportCategory = SportCategory.BASEBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryBasketballCourtTest() {
        val sportCategory = SportCategory.BASKETBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }


    @Test
    fun getReservationsWithPageCategoryFootballCourtTest() {
        val sportCategory = SportCategory.FOOTBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryFutsalTest() {
        val sportCategory = SportCategory.FUTSAL
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryFutsalStadiumTest() {
        val sportCategory = SportCategory.FUTSAL_STADIUM
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() && it.reservations.size == 5 }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryGymTest() {
        val sportCategory = SportCategory.GYM
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryMultiPurposeStadiumTest() {
        val sportCategory = SportCategory.MULTIPURPOSE_STADIUM
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryParkGolfCourseTest() {
        val sportCategory = SportCategory.PARK_GOLF_COURSE
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryPlaygroundTest() {
        val sportCategory = SportCategory.PLAYGROUND
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryTableTennisCourtTest() {
        val sportCategory = SportCategory.TABLE_TENNIS_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryTennisCourtTest() {
        val sportCategory = SportCategory.TENNIS_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryVolleyballCourtTest() {
        val sportCategory = SportCategory.VOLLEYBALL_COURT
        val page = 1
        val size = 5

        val reservesWithPage = getSportReservationService.getReservationsWithPage(
                category = sportCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservations.isNotEmpty() }
                .verifyComplete()
    }
}