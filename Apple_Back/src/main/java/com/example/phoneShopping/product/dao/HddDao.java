package com.example.phoneShopping.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.example.phoneShopping.product.domain.Hdd;
import com.example.phoneShopping.product.dto.param.CreateHddParam;
import com.example.phoneShopping.product.dto.param.UpdateHddParam;

@Mapper
@Repository
public interface HddDao 
{
	List<Hdd> findAllHdd();				// Hdd 정보 전체 조회
	Hdd findByIdHdd(int hddSeq);		// id(seq)로 Hdd 정보 찾기(특정 1개)
	Integer createHdd(CreateHddParam param);	// Hdd 정보 생성
	Integer updateHdd(UpdateHddParam param);	// Hdd 정보 수정
	Integer deleteHdd(int hddSeq);			// Hdd 정보 삭제
}
