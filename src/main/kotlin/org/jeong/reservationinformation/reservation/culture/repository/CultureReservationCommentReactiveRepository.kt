package org.jeong.reservationinformation.reservation.culture.repository

import org.jeong.reservationinformation.reservation.culture.domian.document.CultureReservationComment
import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface CultureReservationCommentReactiveRepository : ReactiveMongoRepository<CultureReservationComment, String> {
    fun findAllByCultureReservationSvcId(pageable: Pageable, sportReservationSvcId: String): Flux<CultureReservationComment>
    fun countByCultureReservationSvcId(sportReservationSvcId: String): Mono<Long>
}