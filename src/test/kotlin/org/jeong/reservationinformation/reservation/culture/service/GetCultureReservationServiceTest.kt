package org.jeong.reservationinformation.reservation.culture.service

import org.jeong.reservationinformation.reservation.culture.domian.enums.CultureCategory
import org.jeong.reservationinformation.reservation.sport.domain.enums.SportCategory
import org.jeong.reservationinformation.reservation.sport.service.GetSportReservationService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import reactor.test.StepVerifier

@SpringBootTest
@TestPropertySource(properties = ["api.key = sample"])
class GetCultureReservationServiceTest {

    @Autowired
    lateinit var getCultureReservationService: GetCultureReservationService


    @Test
    fun getReservationsWithPageCategoryAll() {
        val cultureCategory = CultureCategory.ALL
        val page = 1
        val size = 5

        val reservesWithPage = getCultureReservationService.getReservationsWithPage(
                category = cultureCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryCompetition() {
        val cultureCategory = CultureCategory.COMPETITION
        val page = 1
        val size = 5

        val reservesWithPage = getCultureReservationService.getReservationsWithPage(
                category = cultureCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryConcert() {
        val cultureCategory = CultureCategory.CONCERT
        val page = 1
        val size = 5

        val reservesWithPage = getCultureReservationService.getReservationsWithPage(
                category = cultureCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryPerformance() {
        val cultureCategory = CultureCategory.PERFORMANCE
        val page = 1
        val size = 5

        val reservesWithPage = getCultureReservationService.getReservationsWithPage(
                category = cultureCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryExhibition() {
        val cultureCategory = CultureCategory.EXHIBITION
        val page = 1
        val size = 5

        val reservesWithPage = getCultureReservationService.getReservationsWithPage(
                category = cultureCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }

    @Test
    fun getReservationsWithPageCategoryPreview() {
        val cultureCategory = CultureCategory.PREVIEW
        val page = 1
        val size = 5

        val reservesWithPage = getCultureReservationService.getReservationsWithPage(
                category = cultureCategory.name,
                size = size,
                page = page
        )

        StepVerifier.create(reservesWithPage)
                .expectNextMatches { it.reservationList.isNotEmpty() }
                .verifyComplete()
    }
}