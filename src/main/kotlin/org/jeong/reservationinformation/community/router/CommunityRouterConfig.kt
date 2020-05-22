package org.jeong.reservationinformation.community.router

import org.jeong.reservationinformation.community.handler.comment.PostCommentHandler
import org.jeong.reservationinformation.community.handler.post.PostCrudHandler
import org.jeong.reservationinformation.community.handler.post.PostSearchHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.router

@Configuration
class CommunityRouterConfig(val postCrudHandler: PostCrudHandler,
                            val postSearchHandler: PostSearchHandler,
                            val postCommentHandler: PostCommentHandler) {

    @Bean
    fun postCrudRouter() =
            RouterFunctions.nest(RequestPredicates.path("/community/post"), router {
                listOf(
                        GET("", postCrudHandler::getPost),
                        POST("", postCrudHandler::insertPost),
                        PUT("", postCrudHandler::updatePost),
                        DELETE("", postCrudHandler::deletePost)
                )
            })

    @Bean
    fun postSearchRouter() =
            RouterFunctions.nest(RequestPredicates.path("/community/posts"), router {
                listOf(
                        GET("", postSearchHandler::getPostsWithPaging),
                        GET("/search/category/{category}", postSearchHandler::getPostsByCategoryWithPaging),
                        GET("/search/category/{category}/content", postSearchHandler::getPostsByContentLikeAndPostCategory),
                        GET("/search/category/{category}/title", postSearchHandler::getPostsByTitleLikeAndPostCategory),
                        GET("/search/category/{category}/username", postSearchHandler::getPostsByUsernameLikeAndPostCategory)
                )
            })

    @Bean
    fun postCommentCrudRouter() =
            RouterFunctions.nest(RequestPredicates.path("/community/post"), router {
                listOf(
                        GET("/comments", postCommentHandler::findPostCommentsWithPaging),
                        POST("/comment", postCommentHandler::insertPostComment),
                        PUT("/comment", postCommentHandler::updatePostComment),
                        DELETE("/comment", postCommentHandler::deletePostComment)
                )
            })
}