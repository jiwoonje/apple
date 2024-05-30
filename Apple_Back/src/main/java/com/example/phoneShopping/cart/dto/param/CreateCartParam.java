package com.example.phoneShopping.cart.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartParam 
{
	private int cartSeq;	// 장바구니 번호
	private int memSeq;	// 장바구니 사용하는 회원 정보
}
