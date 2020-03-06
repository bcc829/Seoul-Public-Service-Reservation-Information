package org.jeong.reservationinformation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class ReservationInformationApplication

fun main(args: Array<String>) {
    runApplication<ReservationInformationApplication>(*args)
}
