package com.example.phoneShopping.security;

import java.util.Date;
import com.example.phoneShopping.member.dao.MemberDao;	// MemberDao 사용
import com.example.phoneShopping.member.domain.Member;	// Member 사용
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;	// username(id) 없을 경우 오류 안내해주는 class
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private final MemberDao memberDao;

    public UserDetailsServiceImpl(MemberDao memberDao) 	// 기본 생성자
    {
        this.memberDao = memberDao;
    }

    // username = User (id)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException // 사용자 정보 불러오기
    {
        System.out.println("UserDetailsServiceImpl loadUserByUsername " + new Date());

        Member member = memberDao.findByIdMember(username);
        if (member == null) 
        {
            throw new UsernameNotFoundException(String.format("'%s'는 존재하지 않는 사용자입니다.", username));
        }

        return new UserDetailsImpl(member);
    }
}
