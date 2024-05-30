package com.example.phoneShopping.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.member.domain.Member;
import com.example.phoneShopping.member.dto.param.CreateMemberParam;
import com.example.phoneShopping.member.dto.param.UpdateMemberParam;

@Mapper
@Repository
public interface MemberDao
{
	List<Member> findAllMember();					// Member 전체 조회
	
	Member findByIdMember(String mem_id);			// id로 member찾기(특정 1개)
	
	Integer findByIdSeq(int mem_seq);			// id로 member찾기(특정 1개)
	
	String findByPw(String mem_id);			// id로 member찾기(특정 1개)
	
	Integer isExistUserId(String mem_id);			// id로 이미 존재하는 유저인지 확인
	
	Integer createMember(CreateMemberParam param);	// 회원가입param사용해서 회원가입 하기
	
	Integer updateMember(UpdateMemberParam param);	// 회원가입param사용해서 회원 정보 수정 하기
	
	Integer deleteMember(String mem_id);			// 회원 삭제
}
