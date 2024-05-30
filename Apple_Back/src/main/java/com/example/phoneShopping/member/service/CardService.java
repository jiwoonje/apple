package com.example.phoneShopping.member.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.CardDao;
import com.example.phoneShopping.member.domain.Card;
import com.example.phoneShopping.member.dto.param.CreateCardParam;
import com.example.phoneShopping.member.dto.param.UpdateCardParam;
import com.example.phoneShopping.member.dto.request.CreateCardRequest;
import com.example.phoneShopping.member.dto.request.UpdateCardRequest;
import com.example.phoneShopping.member.dto.response.CreateCardResponse;
import com.example.phoneShopping.member.dto.response.DeleteCardResponse;
import com.example.phoneShopping.member.dto.response.UpdateCardResponse;
import com.example.phoneShopping.member.exception.CardException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CardService 
{
	private final CardDao dao;
	
	@Transactional
	public CreateCardResponse createCard(CreateCardRequest req)
	{
		createCardMethod(req);
		return new CreateCardResponse(req.getCardSeq());
	}
		
	private void createCardMethod(CreateCardRequest req)
	{
		System.out.println("createAddress동작");
		CreateCardParam param = new CreateCardParam(req);
		
		Integer result = dao.createCard(param);
		if(result==0)
		{
			throw new CardException("카드 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Card> findAllCard()
	{
		System.out.println("findAllCard동작");
		List<Card> list = dao.findAllCard();
		
		for(int i = 0; i<dao.findAllCard().size(); i++)
		{
			System.out.println(dao.findAllCard().get(i).getCardSeq());
			System.out.println(dao.findAllCard().get(i).getCardComp());
			System.out.println(dao.findAllCard().get(i).getCardNum());
			System.out.println(dao.findAllCard().get(i).getCardDate());
			System.out.println(dao.findAllCard().get(i).getCardCvc());
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Card findByIdCard(int cardSeq)
	{
		System.out.println("findByIdCard동작");
		dao.findByIdCard(cardSeq);
		System.out.println(dao.findByIdCard(cardSeq).getCardSeq());
		System.out.println(dao.findByIdCard(cardSeq).getCardComp());
		System.out.println(dao.findByIdCard(cardSeq).getCardNum());
		System.out.println(dao.findByIdCard(cardSeq).getCardDate());
		System.out.println(dao.findByIdCard(cardSeq).getCardCvc());
		Card card = new Card(dao.findByIdCard(cardSeq).getCardSeq(), dao.findByIdCard(cardSeq).getCardComp(), dao.findByIdCard(cardSeq).getCardNum(), dao.findByIdCard(cardSeq).getCardDate(), dao.findByIdCard(cardSeq).getCardCvc());
		return card;
	}
	
	@Transactional
	public UpdateCardResponse updateCard(UpdateCardRequest req)
	{
		findByIdCard(req.getCardSeq());
		return new UpdateCardResponse(updateCardMethod(req));
	}
	
	private Integer updateCardMethod(UpdateCardRequest req)
	{
		System.out.println("updateCard동작");
				
		UpdateCardParam param = new UpdateCardParam(req.getCardSeq(), req.getCardComp(), req.getCardNum(), req.getCardDate(), req.getCardCvc());
		
		Integer result = dao.updateCard(param);
		
		if(result==0)
		{
			throw new CardException("카드 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeleteCardResponse deleteCard(int cardSeq)
	{
		System.out.println("deleteCard동작");
		int number = dao.deleteCard(cardSeq);
		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}
		return new DeleteCardResponse(number);
	}
}
