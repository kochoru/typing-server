package com.example.typing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@Configuration
@ComponentScan(basePackages = "com.example.typing")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .indentOutput(true)
                .dateFormat(new StdDateFormat())
                .build();
    }
}
