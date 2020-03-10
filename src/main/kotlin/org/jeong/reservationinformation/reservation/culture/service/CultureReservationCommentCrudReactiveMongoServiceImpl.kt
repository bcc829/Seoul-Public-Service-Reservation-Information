package org.jeong.reservationinformation.reservation.culture.service

import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.culture.domian.document.CultureReservationComment
import org.jeong.reservationinformation.reservation.culture.repository.CultureReservationCommentReactiveRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CultureReservationCommentCrudReactiveMongoServiceImpl(
        private val cultureReservationCommentReactiveRepository: CultureReservationCommentReactiveRepository
) : CultureReservationCommentCrudService {
    override fun getCultureReservationCommentBySvcId(svcId: String): Flux<ReservationCommentVo> =
            cultureReservationCommentReactiveRepository.findByCultureReservationSvcIdOrderByRegisterDateDesc(svcId)
                    .map {
                        it.toReservationCommentVo()
                    }

    override fun insertCultureReservationComment(insertReservationCommentVo: InsertReservationCommentVo): Mono<ReservationCommentVo> =
            cultureReservationCommentReactiveRepository.save(CultureReservationComment(
                            cultureReservationSvcId = insertReservationCommentVo.svcId,
                            userName = insertReservationCommentVo.userName,
                            comment = insertReservationCommentVo.comment,
                            rating = insertReservationCommentVo.rating,
                            password = insertReservationCommentVo.password
                    ))
                    .map {
                        it.toReservationCommentVo()
                    }

    override fun updateCultureReservationComment(updateReservationCommentVo: UpdateReservationCommentVo): Mono<ReservationCommentVo> =
            cultureReservationCommentReactiveRepository.findById(updateReservationCommentVo.id)
                    .flatMap {
                        if (it.password == updateReservationCommentVo.password) {
                            it.rating = updateReservationCommentVo.rating
                            it.comment = updateReservationCommentVo.comment

                            cultureReservationCommentReactiveRepository.save(it)
                        } else {
                            Mono.error(IllegalAccessException("password is not matching"))
                        }
                    }.map {
                        it.toReservationCommentVo()
                    }.switchIfEmpty(Mono.error(NoSuchElementException("${updateReservationCommentVo.id} is not exist")))

    override fun deleteCultureReservationComment(cultureReservationCommentId: String, password: String): Mono<Void> =
            cultureReservationCommentReactiveRepository.findById(cultureReservationCommentId)
                    .flatMap {
                        if(it.password == password) {
                            cultureReservationCommentReactiveRepository.deleteById(cultureReservationCommentId)
                        } else {
                            Mono.error(IllegalAccessException("password is not matching"))
                        }
                    }.switchIfEmpty(
                            Mono.empty()
                    )
}