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
@Schema(description = "Cart Update Request")
public class UpdateCartRequest 
{
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "6")
	private int cartSeq;	// 장바구니 번호
	
	@Schema(description = "Update 회원 정보", example = "2")
	private int memSeq;	// 장바구니 사용하는 회원 정보
	
	public UpdateCartRequest(int memSeq)
	{
		this.memSeq=memSeq;
	}
}
