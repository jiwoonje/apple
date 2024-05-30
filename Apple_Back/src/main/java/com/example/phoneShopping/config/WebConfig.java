package com.example.phoneShopping.config;

import org.springframework.http.HttpMethod;	// Http Request 관련 method가 있는 class
import org.springframework.web.servlet.config.annotation.CorsRegistry;	// CORS관련 기능에 도움을 주는 역할
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;	// Callback method 정의한 Interface

public class WebConfig  implements WebMvcConfigurer
{
    @Override
    public void addCorsMappings(CorsRegistry registry) // CORS 정책 처리 - http://localhost:8090으로 들어오는 모든 내용에 대해 어떤 method를 쓰든 다 허용한 설정
    {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PATCH.name(),
                HttpMethod.DELETE.name());
    }
}
