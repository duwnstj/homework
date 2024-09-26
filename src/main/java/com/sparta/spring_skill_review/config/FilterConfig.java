package com.sparta.spring_skill_review.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final JwtUtil jwtUtil;

    @Bean
    public FilterRegistrationBean<com.sparta.spring_skill_review.config.JwtFilter> jwtFilter() {
        FilterRegistrationBean<com.sparta.spring_skill_review.config.JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new com.sparta.spring_skill_review.config.JwtFilter(jwtUtil));
        registrationBean.addUrlPatterns("/*"); // 필터를 적용할 URL 패턴을 지정합니다.

        return registrationBean;
    }
}
