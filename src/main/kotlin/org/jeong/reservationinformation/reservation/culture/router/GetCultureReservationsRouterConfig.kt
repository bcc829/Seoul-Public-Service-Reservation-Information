package org.jeong.reservationinformation.reservation.culture.router

import org.jeong.reservationinformation.reservation.culture.handler.GetCultureReservationsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class GetCultureReservationsRouterConfig(
        private val getCultureReservationsHandler: GetCultureReservationsHandler
) {
    @Bean
    fun getCultureReservationsRouter() =
            nest(path("/reservations/culture"), router {
                listOf(
                        GET("", getCultureReservationsHandler::getReservations)
                )
            })
}