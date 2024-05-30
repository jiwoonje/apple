package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.CreateCardRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCardParam 
{
	private int cardSeq;		// 카드 구분 번호
	private String cardComp;	// 카드회사
	private String cardNum;		// 카드번호
	private String cardDate;	// 카드 유효기간
	private int cardCvc;		// 카드 CVC
	
	public CreateCardParam(CreateCardRequest req)
	{
		this.cardComp=req.getCardComp();
		this.cardNum=req.getCardNum();
		this.cardDate=req.getCardDate();
		this.cardCvc=req.getCardCvc();
	}
}
