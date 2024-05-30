package com.example.phoneShopping.cart.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Cart Create Request")
public class CreateCartRequest 
{
	private int cartSeq;	// 장바구니 번호
	
	@Schema(description = "Create 회원 정보", example = "1")
	private int memSeq;	// 장바구니 사용하는 회원 정보
	
	public CreateCartRequest(int memSeq)
	{
		this.memSeq=memSeq;
	}
}
