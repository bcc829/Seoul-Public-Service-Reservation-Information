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
            sportReservationCommentReactiveRepository.findBySportReservationSvcId(svcId)
                    .map {
                        ReservationCommentVo(
                                id = it.id!!,
                                userName = it.userName,
                                rating = it.rating,
                                comment = it.comment,
                                svcId = it.sportReservationSvcId
                        )
                    }


    override fun insertSportReservationComment(insertReservationCommentVo: InsertReservationCommentVo): Mono<ReservationCommentVo> =
            sportReservationCommentReactiveRepository.save(SportReservationComment(
                    sportReservationSvcId = insertReservationCommentVo.svcId,
                    comment = insertReservationCommentVo.comment,
                    rating = insertReservationCommentVo.rating,
                    userName = insertReservationCommentVo.userName,
                    password = insertReservationCommentVo.password
            )).map {
                ReservationCommentVo(
                        id = it.id!!,
                        userName = it.userName,
                        rating = it.rating,
                        comment = it.comment,
                        svcId = it.sportReservationSvcId
                )
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
                        ReservationCommentVo(
                                userName = it.userName,
                                comment = it.comment,
                                rating = it.rating,
                                id = sportReservationCommentId,
                                svcId = it.sportReservationSvcId
                        )
                    }.switchIfEmpty(Mono.error(NoSuchElementException("$sportReservationCommentId is not exist")))

    override fun deleteSportReservationComment(sportReservationCommentId: String): Mono<Void> =
        sportReservationCommentReactiveRepository.deleteById(sportReservationCommentId)
}
