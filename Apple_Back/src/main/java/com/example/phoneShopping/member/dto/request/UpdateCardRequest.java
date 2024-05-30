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
@Schema(description = "Card Update Request")
public class UpdateCardRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "6")
	private int cardSeq;		// 카드 구분 번호
	
	@NotBlank
	@Schema(description = "Update 카드 회사", example = "bbb")
	private String cardComp;	// 카드회사
	
	@NotBlank
	@Schema(description = "Update 카드 번호", example = "7777-7777-7777-7777")
	private String cardNum;		// 카드번호
	
	@NotBlank
	@Schema(description = "Update 카드 유효기간", example = "25/07")
	private String cardDate;	// 카드 유효기간
	
	@NotBlank
	@Schema(description = "Update 카드 CVC", example = "257")
	private int cardCvc;		// 카드 CVC
	
	public UpdateCardRequest(String cardComp, String cardNum, String cardDate, int cardCvc)
	{
		this.cardComp=cardComp;
		this.cardNum=cardNum;
		this.cardDate=cardDate;
		this.cardCvc=cardCvc;
	}
}
