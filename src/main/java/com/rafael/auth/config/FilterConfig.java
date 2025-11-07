package com.rafael.auth.config;

import com.rafael.auth.filter.JwtAuthenticationFilter;
import com.rafael.auth.services.ApplicationUserDetailsService;
import com.rafael.auth.services.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(ApplicationUserDetailsService userDetailsService, JwtService jwtService) {
        return new JwtAuthenticationFilter(userDetailsService, jwtService);
    }
}
