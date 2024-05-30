package com.example.phoneShopping.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.product.domain.Plus;
import com.example.phoneShopping.product.dto.param.CreatePlusParam;
import com.example.phoneShopping.product.dto.param.UpdatePlusParam;



@Mapper
@Repository
public interface PlusDao 
{
	List<Plus> findAllPlus();				// Plus 정보 전체 조회
	Plus findByIdPlus(int plusSeq);		// id(seq)로 Plus 정보 찾기(특정 1개)
	Integer createPlus(CreatePlusParam param);	// Plus 정보 생성
	Integer updatePlus(UpdatePlusParam param);	// Plus 정보 수정
	Integer deletePlus(int plusSeq);			// Plus 정보 삭제
}
