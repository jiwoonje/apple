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
@Schema(description = "CartProduct Create Request")
public class CreateCartProductRequest 
{
	private int cartpSeq;
	
	@Schema(description = "Create 카트 정보", example = "1")
	private int cartSeq;
	
	@Schema(description = "Create 상품 정보", example = "aaa")
	private String prodSeq;
	
	@Schema(description = "Create 상품 갯수", example = "1")
	private int cartpCnt;
	
	public CreateCartProductRequest(int cartSeq, String prodSeq, int cartpCnt)
	{
		this.cartSeq=cartSeq;
		this.prodSeq=prodSeq;
		this.cartpCnt=cartpCnt;
	}
}
