package org.jeong.reservationinformation.reservation.sport.repository

import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface SportReservationCommentReactiveRepository : ReactiveMongoRepository<SportReservationComment, String> {
    fun findBySportReservationSvcId(sportReservationSvcId: String): Flux<SportReservationComment>
}