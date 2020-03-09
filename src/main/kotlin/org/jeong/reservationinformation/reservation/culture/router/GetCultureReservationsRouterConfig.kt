package org.jeong.reservationinformation.reservation.culture.router

import org.jeong.reservationinformation.reservation.culture.handler.CultureReservationCommentHandler
import org.jeong.reservationinformation.reservation.culture.handler.GetCultureReservationsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class GetCultureReservationsRouterConfig(
        private val getCultureReservationsHandler: GetCultureReservationsHandler,
        private val cultureReservationCommentHandler: CultureReservationCommentHandler
) {
    @Bean
    fun getCultureReservationsRouter() =
            nest(path("/culture/reservations"), router {
                listOf(
                        GET("", getCultureReservationsHandler::getReservations)
                )
            })

    @Bean
    fun getReservationCommentRouter() =
            nest(path("/culture/reservation"), router {
                listOf(
                        GET("/comments", cultureReservationCommentHandler::getCommentsBySvcId),
                        POST("/comment", cultureReservationCommentHandler::insertComment),
                        PUT("/comment", cultureReservationCommentHandler::updateComment),
                        DELETE("/comment", cultureReservationCommentHandler::deleteComment)
                )
            })
}