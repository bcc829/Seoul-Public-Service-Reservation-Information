package org.jeong.reservationinformation.reservation.router

import org.jeong.reservationinformation.reservation.handler.GetReservationListHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router
import org.springframework.web.server.WebFilter

@Configuration
@EnableWebFlux
class GetReservationListRouterConfig(
        private val getReservationListHandler: GetReservationListHandler
) {
    @Bean
    fun getReservationListRouter() =
            nest(path("/reservations"), router {
                listOf(
                        GET("", getReservationListHandler::getReservationList)
                )
            })
}