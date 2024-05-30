//package com.example.phoneShopping;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.phoneShopping.member.domain.Card;
//import com.example.phoneShopping.member.dto.request.CreateCardRequest;
//import com.example.phoneShopping.member.dto.request.UpdateCardRequest;
//import com.example.phoneShopping.member.service.CardService;
//
//@SpringBootTest
//public class CardTest 
//{
//	@Autowired
//	CardService service;
//	
//	//@Test
//	void create()
//	{
//		Card card = new Card(1, "카드 회사", "카드번호", "카드 유효기간", 111);
//		CreateCardRequest req = new CreateCardRequest(card.getCard_seq(), card.getCard_comp(), card.getCard_num(), card.getCard_date(), card.getCard_cvc());
//		service.createCard(req);
//	}
//	
//	//@Test
//	void create1()
//	{
//		Card card = new Card(2, "카드 회사", "카드번호", "카드 유효기간", 111);
//		CreateCardRequest req = new CreateCardRequest(card.getCard_seq(), card.getCard_comp(), card.getCard_num(), card.getCard_date(), card.getCard_cvc());
//		service.createCard(req);
//		
//		Card card1 = new Card(3, "카드 회사", "카드번호", "카드 유효기간", 111);
//		CreateCardRequest req1 = new CreateCardRequest(card1.getCard_seq(), card1.getCard_comp(), card1.getCard_num(), card1.getCard_date(), card1.getCard_cvc());
//		service.createCard(req1);
//		
//		Card card2 = new Card(4, "카드 회사", "카드번호", "카드 유효기간", 111);
//		CreateCardRequest req2 = new CreateCardRequest(card2.getCard_seq(), card2.getCard_comp(), card2.getCard_num(), card2.getCard_date(), card2.getCard_cvc());
//		service.createCard(req2);
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdateCardRequest req = new UpdateCardRequest(1, "삼성", "1111-1111-1111-1111", "08/24", 123);
//		service.updateCard(req);
//		UpdateCardRequest req1 = new UpdateCardRequest(2, "국민", "2222-2222-2222-2222", "09/24", 456);
//		service.updateCard(req1);
//		UpdateCardRequest req2 = new UpdateCardRequest(3, "신한", "3333-3333-3333-3333", "10/24", 789);
//		service.updateCard(req2);
//		UpdateCardRequest req3 = new UpdateCardRequest(4, "기업", "4444-4444-4444-4444", "11/24", 012);
//		service.updateCard(req3);
//	}
//	
//	
//	//@Test
//	void delete()
//	{
//		service.deleteCard(4);
//	}
//	
//	
//	//@Test
//	void getAll() 
//	{
//		service.findAllCard();
//	}
//	
//	//@Test
//	void getOne()
//	{
//		service.findByIdCard(1);
//	}
//}
