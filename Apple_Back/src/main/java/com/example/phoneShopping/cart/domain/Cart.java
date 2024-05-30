package com.example.phoneShopping.cart.domain;

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
public class Cart 
{
	@Schema(description = "장바구니 번호(자동 생성)")
	private int cartSeq;
	
	@Schema(description = "장바구니를 사용하는 회원 정보")
	private int memSeq;

    public Cart(int memSeq)
    {
    	this.memSeq = memSeq;
    }
}
