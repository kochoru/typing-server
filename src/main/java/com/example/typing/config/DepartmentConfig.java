package com.example.typing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.typing.dto.DepartmentList;

@Configuration
@PropertySource(value = "classpath:department.properties")
public class DepartmentConfig {

    @Value("${department.label}")
    private String[] labels;

    public String[] getLables() {
        return this.labels;
    }

    @Bean
    public DepartmentList departmentList() {
        return new DepartmentList(labels);
    }
}
