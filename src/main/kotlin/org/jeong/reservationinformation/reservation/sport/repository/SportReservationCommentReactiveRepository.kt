package org.jeong.reservationinformation.reservation.sport.repository

import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface SportReservationCommentReactiveRepository : ReactiveMongoRepository<SportReservationComment, String> {
    fun findAllBySportReservationSvcId(pageable: Pageable, sportReservationSvcId: String): Flux<SportReservationComment>
    fun countBySportReservationSvcId(sportReservationSvcId: String): Mono<Long>
}