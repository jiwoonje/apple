package com.example.phoneShopping.member.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCardParam 
{
	private int cardSeq;
	private String cardComp;	// 카드회사
	private String cardNum;		// 카드번호
	private String cardDate;	// 카드 유효기간
	private int cardCvc;		// 카드 CVC
	
	public UpdateCardParam(String cardComp, String cardNum, String cardDate, int cardCvc)
	{
		this.cardComp=cardComp;
		this.cardNum=cardNum;
		this.cardDate=cardDate;
		this.cardCvc=cardCvc;
	}
}
