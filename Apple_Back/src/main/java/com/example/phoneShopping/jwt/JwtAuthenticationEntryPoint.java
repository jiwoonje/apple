package com.example.phoneShopping.jwt;

import java.io.IOException;							// Program이 동작 중에 Input과 Output에서 Error가 발생할 경우, Error가 발생한 곳에서 IOException을 발생시킨다. = 오류 내용 출력한다.
import jakarta.servlet.http.HttpServletRequest;		// HTTP Request 통신만을 위한 Interface 1
import jakarta.servlet.http.HttpServletResponse;	// HTTP Request 통신만을 위한 Interface 2
import org.springframework.security.core.AuthenticationException;	// Spring Security에서 인증에 대한 예외처리 - 인증에 문제가 생길 경우 발생하는 exception
import org.springframework.security.web.AuthenticationEntryPoint;	// AuthenticationEntryPoint라는 interface를 구현한 구현체 - 로그인 페이지로 이동, 401 오류 전달 등의 작업 진행 / Spring Security에서 제공
import org.springframework.stereotype.Component;	// 특정 java class를 Bean scanning과정에서 자동으로 Application에 등록될 수 있도록 돕는 역할 / Stereotype의 핵심


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint
{
    @Override	// 이 method는 부모 classs에 있는 method를 Override했음을 명시적으로 선언
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException 
    {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");	// 인증되지 않은 사용자들에게 Error code(401 : Unauthorized)를 return한다.
    }
}
