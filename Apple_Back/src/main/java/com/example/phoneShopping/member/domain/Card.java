package com.example.phoneShopping.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Cart Domain")
public class Card 
{
	@Schema(description = "카드 구분 번호(자동 생성)")
	private int cardSeq;
	
	@Schema(description = "카드회사")
	private String cardComp;
	
	@Schema(description = "카드번호")
	private String cardNum;
	
	@Schema(description = "카드 유효기간")
	private String cardDate;
	
	@Schema(description = "카드 CVC")
	private int cardCvc;
	
	public Card(String cardComp, String cardNum, String cardDate, int cardCvc)
	{
		this.cardComp=cardComp;
		this.cardNum=cardNum;
		this.cardDate=cardDate;
		this.cardCvc=cardCvc;
	}
}
