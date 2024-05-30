package com.example.phoneShopping.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Card Create Request")
public class CreateCardRequest 
{
	@NotBlank
	private int cardSeq;		// 카드 구분 번호
	
	@NotBlank
	@Schema(description = "Create 카드 회사", example = "aaa")
	private String cardComp;	// 카드회사
	
	@NotBlank
	@Schema(description = "Create 카드 번호", example = "6666-6666-6666-6666")
	private String cardNum;		// 카드번호
	
	@NotBlank
	@Schema(description = "Create 카드 유효기간", example = "25/06")
	private String cardDate;	// 카드 유효기간
	
	@NotBlank
	@Schema(description = "Create 카드 CVC", example = "256")
	private int cardCvc;		// 카드 CVC
	
	public CreateCardRequest(String cardComp, String cardNum, String cardDate, int cardCvc)
	{
		this.cardComp=cardComp;
		this.cardNum=cardNum;
		this.cardDate=cardDate;
		this.cardCvc=cardCvc;
	}
}
