package com.example.phoneShopping.security;

import java.util.Collection; // 여러 개의 객체를 하나로 묶기 위해 Collection 사용
import java.util.Collections; // Colleection 사용하기 위한 method들 모음
import com.example.phoneShopping.member.domain.Member; // Member class 사용
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails
{
    private final Member member; // 회원 객체 선언

    public UserDetailsImpl(Member member) // 기본 생성자
    {
        this.member = member;
    }

    public Member getMember() 	// 회원 객체 가져오기
    {
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() // 가져온 회원의 권한 return
    {
        return Collections.emptyList();	// List 형태로 반환 -> 직렬화 가능
    }

    @Override
    public String getPassword() // 가져온 회원의 PW return
    {
        return member.getMemPw();
    }

    @Override
    public String getUsername() // 가져온 회원의 이름 return
    {
        return member.getMemId();
    }

    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }	// 여기까지가 사이트 내에서 일정 기간 동안 로그인 안 하면 휴면계정으로 전환할 것을 명시
}
