package com.example.phoneShopping.jwt;

import io.jsonwebtoken.ExpiredJwtException;	// input/output을 통한 JWT를 이용한 검증 과정에서 현재 시간이 초과된 경우(expired - 인증 시간 초과) Error발생시킨다
import io.jsonwebtoken.SignatureException;	// JWT에서 Signature가 다를 경우 Error 발생시킨다.
import java.io.IOException;
import java.util.Arrays;					// 배열을 다루기 위한 다양한 메소드가 포함된 클래스 - static이므로 객체 생성 하지 않고 바로 사용 가능
import jakarta.servlet.FilterChain;			// Client가 요청한 정보로 기존의 정보를 바꾸는 역할
import jakarta.servlet.ServletException;	// Servlet과 관련된 Error가 발생할 경우 해당 Error내용을 출력한다.
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;	// 평문으로 id, pw 구현
import org.springframework.security.core.authority.SimpleGrantedAuthority;				// 권한 내용 확인
import org.springframework.security.core.context.SecurityContextHolder;					// 보안 설정 적용
import org.springframework.security.core.userdetails.UserDetails;						// 사용자 정보 제공
import org.springframework.security.core.userdetails.UserDetailsService;				// 사용자 상세 정보 제공
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;	// 인증관련 상세 정보
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;								// 한줄씩 명령어 실행

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    private final UserDetailsService userDetailsService; // 사용자 상세정보 내용을 위해 선언
    private final JwtTokenUtil jwtTokenUtil;			 // JWT 사용하기 위해 선언

    public JwtAuthenticationFilter(	// JWT방식을 사용하기 위해 filter 생성
        UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) 
    {
        this.userDetailsService = userDetailsService;	// User상세 정보 설정
        this.jwtTokenUtil = jwtTokenUtil;				// Token 정보 설정
    }

    
    String HEADER_STRING = "Authorization";	// JWT Headre설정
    String TOKEN_PREFIX = "Bearer ";		// JWT 시작시 문구 설정

    
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException // 내부 필터 생성 - 필터를 이용해서 인증 처리 
    {
        String header = req.getHeader(HEADER_STRING);	// 인증에서 사용할 헤더 설정
        String userId = null;							// 인증에서 사용할 사용자 id
        String authToken = null;						// 인증에서 사용할 Token
        if (header != null && header.startsWith(TOKEN_PREFIX)) // Token의 헤더에 값이 존재하고, Token의 헤더 부분이 TOKEN_PREFIX로 시작할 경우
        {
            authToken = header.replace(TOKEN_PREFIX,""); // 인증에서 사용할 Token의 헤더에 인증에서 사용할 Token를 넣는다
            try 
            {
                userId = jwtTokenUtil.getUsernameFromToken(authToken);	 // 인증에서 사용할 사용자 id에 인증에서 사용할 Token의 id부분을 넣기
            } 
            
            catch (IllegalArgumentException e) // Error발생 경우 1
            {
                System.out.println("JwtAuthenticationFilter: token error (fail get user id) !"); // Token에 사용자 id 가져오기 실패
                e.printStackTrace();
            }
            
            catch (ExpiredJwtException e) // Error발생 경우 2
            {
                System.out.println("JwtAuthenticationFilter: expired token !"); // Token 기간 만료
                e.printStackTrace();
            }
            
            catch(SignatureException e) // Error발생 경우 3
            {
                System.out.println("JwtAuthenticationFilter: invalid member !"); // 없는 사용자 정보
                e.printStackTrace();
            }
        } 
        
        else // if조건 만족X시
        {
            System.out.println("JwtAuthenticationFilter: request that do not require authorization."); // 인증 요청 불가능
        }
        
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) // 사용자 id가 존재하고, 현재 인증된 정보가 아직 없는 경우
        {

            UserDetails userDetails = userDetailsService.loadUserByUsername(userId); // 사용자 상세 정보에 사용자 id와 관련된 정보를 넣는다.

            if (jwtTokenUtil.validateToken(authToken, userDetails)) // 인증에 사용할 Token과 사용자 상세 정보에 대해 JWT비교
            {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))); //관리자 권한으로 id와 pw생성
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req)); // 요청한 정보에 대해 상세한 인증 절차 진행
                logger.info("authenticated user " + userId + ", setting security context"); // 로그 기록 남기기
                SecurityContextHolder.getContext().setAuthentication(authentication); // 위에 인증 정차 진행후 얻은 정보를 저장
            }
        }

        chain.doFilter(req, res); //요청과 응답을 하나로 묶어서 진행
    }
}
