package com.example.typing.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(
                    "/index.html",
                    "/api/login",
                    "/images/**",
                    "/scripts/**",
                    "/styles/**",
                    "/views/**")
            .permitAll()
            .anyRequest()
            .authenticated();

    }



}
