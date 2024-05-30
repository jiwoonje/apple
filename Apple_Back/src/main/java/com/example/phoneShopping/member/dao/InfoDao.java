package com.example.phoneShopping.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.member.domain.Info;
import com.example.phoneShopping.member.dto.param.CreateInfoParam;
import com.example.phoneShopping.member.dto.param.UpdateInfoParam;


@Mapper
@Repository
public interface InfoDao 
{
	List<Info> findAllInfo();								// 개인 정보 전체 조회
	Info findByIdInfo(int info_seq);				// id(seq)로 개인 정보 찾기(특정 1개)
	Integer createInfo(CreateInfoParam param);		// 개인 정보 생성 param사용해서 개인 정보 생성
	Integer updateInfo(UpdateInfoParam param);		// 개인 정보 생성 param사용해서 개인 정보 수정
	Integer deleteInfo(int info_seq);			// 개인 정보 삭제
}
