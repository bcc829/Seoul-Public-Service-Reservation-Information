package org.jeong.reservationinformation.reservation.sport.service

import org.jeong.reservationinformation.common.domain.PaginatedObject
import org.jeong.reservationinformation.common.util.PageUtil
import org.jeong.reservationinformation.reservation.common.domain.vo.InsertReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.ReservationCommentVo
import org.jeong.reservationinformation.reservation.common.domain.vo.UpdateReservationCommentVo
import org.jeong.reservationinformation.reservation.sport.domain.document.SportReservationComment
import org.jeong.reservationinformation.reservation.sport.repository.SportReservationCommentReactiveRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SportReservationCommentCrudReactiveMongoServiceImpl(
        val sportReservationCommentReactiveRepository: SportReservationCommentReactiveRepository,
        val pageUtil: PageUtil
) : SportReservationCommentCrudService {

    override fun getSportReservationCommentBySvcIdWithPaging(pageable: Pageable, svcId: String): Mono<PaginatedObject<ReservationCommentVo>> {
        val totalCount = sportReservationCommentReactiveRepository.countBySportReservationSvcId(svcId)
        val contents = sportReservationCommentReactiveRepository
                .findAllBySportReservationSvcId(pageable, svcId)
                .map { it.toReservationCommentVo() }
                .collectList()

        return pageUtil.makePagingObjectPublisher(pageable, totalCount, contents)
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

    override fun updateSportReservationComment(updateReservationCommentVo: UpdateReservationCommentVo): Mono<ReservationCommentVo> =
            sportReservationCommentReactiveRepository.findById(updateReservationCommentVo.id)
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
                    }.switchIfEmpty(Mono.error(NoSuchElementException("${updateReservationCommentVo.id} is not exist")))

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
