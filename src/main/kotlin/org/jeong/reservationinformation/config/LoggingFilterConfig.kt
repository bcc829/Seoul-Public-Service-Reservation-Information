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
                val startTime = System.currentTimeMillis()

                return@WebFilter chain.filter(exchange).doAfterTerminate {
                    logger.info("""{"path":${exchange.request.path}, "method":${exchange.request.method},"params":"${exchange.request.queryParams}","time": ${System.currentTimeMillis() - startTime}}
                    """.trimIndent())
                }
            }
}

