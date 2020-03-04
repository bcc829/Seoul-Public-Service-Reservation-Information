package org.jeong.reservationinformation.reservation.sport.router

import org.jeong.reservationinformation.reservation.sport.handler.GetSportReservationsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class GetSportReservationsRouterConfig(
        private val getSportReservationsHandler: GetSportReservationsHandler
) {
    @Bean
    fun getSportReservationsRouter() =
            nest(path("/reservations/sport"), router {
                listOf(
                        GET("", getSportReservationsHandler::getReservations)
                )
            })
}