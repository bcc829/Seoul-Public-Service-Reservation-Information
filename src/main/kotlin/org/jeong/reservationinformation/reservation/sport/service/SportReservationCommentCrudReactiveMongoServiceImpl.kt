package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.jeong.reservationinformation.reservation.sport.repository.SportReservationCommentReactiveRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SportReservationCommentCrudReactiveMongoServiceImpl(
        private val sportReservationCommentReactiveRepository: SportReservationCommentReactiveRepository
) : SportReservationCommentCrudService {

    override fun getSportReservationCommentBySvcId(svcId: String): Flux<ReservationCommentVo> =
            sportReservationCommentReactiveRepository.findBySportReservationSvcIdOrderByRegisterDateDesc(svcId)
                    .map {
                        it.toReservationCommentVo()
                    }


    override fun insertSportReservationComment(insertReservationCommentVo: InsertReservationCommentVo): Mono<ReservationCommentVo> =
            sportReservationCommentReactiveRepository.save(SportReservationComment(
                    sportReservationSvcId = insertReservationCommentVo.svcId,
                    comment = insertReservationCommentVo.comment,
                    rating = insertReservationCommentVo.rating,
                    userName = insertReservationCommentVo.userName,
                    password = insertReservationCommentVo.password
            )).map {
                it.toReservationCommentVo()
            }

    override fun updateSportReservationComment(updateReservationCommentVo: UpdateReservationCommentVo,
                                               sportReservationCommentId: String): Mono<ReservationCommentVo> =
            sportReservationCommentReactiveRepository.findById(sportReservationCommentId)
                    .flatMap {
                        if (it.password == updateReservationCommentVo.password) {
                            it.rating = updateReservationCommentVo.rating
                            it.comment = updateReservationCommentVo.comment

                            sportReservationCommentReactiveRepository.save(it)
                        } else {
                            Mono.error(IllegalAccessException("password is not matching"))
                        }
                    }.map {
                        it.toReservationCommentVo()
                    }.switchIfEmpty(Mono.error(NoSuchElementException("$sportReservationCommentId is not exist")))

    override fun deleteSportReservationComment(sportReservationCommentId: String, password: String): Mono<Void> =
        sportReservationCommentReactiveRepository.findById(sportReservationCommentId)
                .flatMap {
                    if(it.password == password) {
                        sportReservationCommentReactiveRepository.deleteById(sportReservationCommentId)
                    }
                    else
                        Mono.error(IllegalAccessException("password is not matching"))
                }.switchIfEmpty(
                        Mono.empty()
                )
}
