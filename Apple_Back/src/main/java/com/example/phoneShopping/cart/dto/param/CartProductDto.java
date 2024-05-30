package com.example.phoneShopping.cart.dto.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductDto 
{
	@NotNull(message = "상품 아이디는 필수 입력 값 입니다.")
	private String cartpSeq;
	
	@Min(value = 1, message = "최소 1개 이상 담아주세요")
	private int cartpCnt;
}
