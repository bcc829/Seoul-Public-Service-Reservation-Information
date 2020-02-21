package org.jeong.reservationinformation.config

import org.jeong.reservationinformation.util.Log
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.WebFilter


@Configuration
class LoggingFilterConfig {

    companion object LOG : Log()

    @Bean
    fun loggingFilter(): WebFilter =
            WebFilter { exchange, chain ->
                val request = exchange.request
                val startTime = System.currentTimeMillis()

                return@WebFilter chain.filter(exchange).doAfterTerminate {
                    val endTime = System.currentTimeMillis()

                    logger.info("""
                        {"method":${request.method},"params":"${request.queryParams}","time": ${endTime - startTime}}
                    """.trimIndent())
                }
            }
}

