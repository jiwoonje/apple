package com.example.phoneShopping.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.member.domain.Card;
import com.example.phoneShopping.member.dto.param.CreateCardParam;
import com.example.phoneShopping.member.dto.param.UpdateCardParam;

@Mapper
@Repository
public interface CardDao 
{
	List<Card> findAllCard();								// Card 정보 전체 조회
	Card findByIdCard(int cardSeq);				// id(seq)로 Card 정보 찾기(특정 1개)
	Integer createCard(CreateCardParam param);		// Card 정보 생성 param사용해서 Card 정보 생성
	Integer updateCard(UpdateCardParam param);		// Card 정보 생성 param사용해서 Card 정보 수정
	Integer deleteCard(int cardSeq);			// Card 정보 삭제
}
