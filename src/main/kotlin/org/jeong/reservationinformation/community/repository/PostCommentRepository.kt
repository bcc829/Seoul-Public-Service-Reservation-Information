package org.jeong.reservationinformation.community.repository

import org.jeong.reservationinformation.community.domain.document.PostComment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostCommentRepository : ReactiveMongoRepository<PostComment, String>