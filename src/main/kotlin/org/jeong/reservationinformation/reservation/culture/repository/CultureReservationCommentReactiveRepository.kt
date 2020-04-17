package org.jeong.reservationinformation.reservation.culture.repository

import org.jeong.reservationinformation.reservation.culture.domian.document.CultureReservationComment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CultureReservationCommentReactiveRepository : ReactiveMongoRepository<CultureReservationComment, String> {
    fun findByCultureReservationSvcIdOrderByRegisterDateDesc(cultureReservationSvcId: String)
            : Flux<CultureReservationComment>
}