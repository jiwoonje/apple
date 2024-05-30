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
@Schema(description = "CartProduct Update Request")
public class UpdateCartProductRequest 
{
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "19")
	private int cartpSeq;
	
	@Schema(description = "Update 카트 정보", example = "2")
	private int cartSeq;
	
	@Schema(description = "Update 상품 정보", example = "bbb")
	private String prodSeq;
	
	@Schema(description = "Update 상품 갯수", example = "2")
	private int cartpCnt;
	
	public UpdateCartProductRequest(int cartSeq, String prodSeq, int cartpCnt)
	{
		this.cartSeq=cartSeq;
		this.prodSeq=prodSeq;
		this.cartpCnt=cartpCnt;
	}
}
