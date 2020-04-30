package org.jeong.reservationinformation.community.handler.comment

import org.jeong.reservationinformation.community.service.comment.PostCommentCrudService
import org.springframework.stereotype.Component

@Component
class PostCommentHandler(val postCommentCrudService: PostCommentCrudService) {

}