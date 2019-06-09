package me.kochoru.typing.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.transaction.annotation.EnableTransactionManagement

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.util.StdDateFormat

@Configuration
@ComponentScan(basePackages = ["me.kochoru.typing"])
@EnableTransactionManagement
class AppConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        return Jackson2ObjectMapperBuilder.json()
                .indentOutput(true)
                .dateFormat(StdDateFormat())
                .build()
    }
}
