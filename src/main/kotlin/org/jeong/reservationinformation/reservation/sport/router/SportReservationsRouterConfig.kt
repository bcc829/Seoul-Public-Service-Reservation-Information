package org.jeong.reservationinformation.reservation.sport.router

import org.jeong.reservationinformation.reservation.sport.handler.GetSportReservationsHandler
import org.jeong.reservationinformation.reservation.sport.handler.SportReservationCommentHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class SportReservationsRouterConfig(
        private val getSportReservationsHandler: GetSportReservationsHandler,
        private val sportReservationCommentHandler: SportReservationCommentHandler
) {
    @Bean
    fun getSportReservationsRouter() =
            nest(path("/reservation/sport"), router {
                listOf(
                        GET("", getSportReservationsHandler::getReservations),
                        GET("/comments", sportReservationCommentHandler::getCommentsBySvcId),
                        POST("/comment", sportReservationCommentHandler::insertComment),
                        PUT("/comment", sportReservationCommentHandler::updateComment),
                        DELETE("/comment", sportReservationCommentHandler::deleteComment)
                )
            })
}