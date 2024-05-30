package com.example.phoneShopping.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.product.domain.Color;
import com.example.phoneShopping.product.dto.param.CreateColorParam;
import com.example.phoneShopping.product.dto.param.UpdateColorParam;

@Mapper
@Repository
public interface ColorDao 
{
	List<Color> findAllColor();				// Color 정보 전체 조회
	Color findByIdColor(int colorSeq);		// id(seq)로 Color 정보 찾기(특정 1개)
	Integer createColor(CreateColorParam param);	// Color 정보 생성
	Integer updateColor(UpdateColorParam param);	// Color 정보 수정
	Integer deleteColor(int colorSeq);			// Color 정보 삭제
}
