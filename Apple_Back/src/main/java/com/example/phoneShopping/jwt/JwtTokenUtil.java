package com.example.phoneShopping.jwt;

import io.jsonwebtoken.Claims;				// JWT의 claim들의 집합
import io.jsonwebtoken.Jwts;				// JWT instance 생성
import io.jsonwebtoken.SignatureAlgorithm;	// JWT signature 정의
import java.io.Serializable;				// data들을 직렬화/역직렬화 
import java.util.Date;						// ms단위로 시간 표현
import java.util.HashMap;					// Hash Table사용
import java.util.Map;						// key-value쌍 객체 사용
import java.util.function.Function;			// 함수 사용
import org.springframework.beans.factory.annotation.Value;	// Field, Method, Constructor를 사용
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil implements Serializable // JWT를 직렬화 역직렬화 과정을 통해 만드는 작업
{
    private static final long serialVersionUID = -2550185165626007488L; // 직렬화할 때 사용할 version 정의

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60; // JWT길이 정의

    @Value("${jwt.secret}")
    private String secret;	// jwt.secret의 값을 가져와서 secret이라는 String에 저장

    //retrieve username from jwt token = JWT에 있는 사용자 이름 가져오기
    public String getUsernameFromToken(String token) 
    {
        return getClaimFromToken(token, Claims::getSubject);
    }

    
    //retrieve expiration date from jwt token = JWT에 있는 만료기간 가져오기
    public Date getExpirationDateFromToken(String token) 
    {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    
    // JWT에 있는 claim 처리 방식 정의
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) 
    {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    
    // for retrieveing any information from token we will need the secret key = 암호키를 이용해 token의 모든 정보 가져오기
    private Claims getAllClaimsFromToken(String token) 
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    
    // check if the token has expired = token 만료기간 지났는지 확인
    private Boolean isTokenExpired(String token) 
    {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    
    // generate token for user = 사용자를 위해 토큰 생성
    public String generateToken(UserDetails userDetails) 
    {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    
    //while creating the token = 토큰 만들어 지는 동안 진행되는 과정
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID = Token의 claim들을 정의
    //2. Sign the JWT using the HS512 algorithm and secret key. = HS512 Algotirhm과 암호키를 이용해 JWT의 sign만들기
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1) = Sign 직렬화과정을 간단하게 만들기
    //   compaction of the JWT to a URL-safe string = JWT에 ASCII문자가 정상적으로 전송되도록 간단하게 만드는 작업
    private String doGenerateToken(Map<String, Object> claims, String subject) 
    {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    
    //validate token = 제대로 된 토큰인지 확인
    public Boolean validateToken(String token, UserDetails userDetails) 
    {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
