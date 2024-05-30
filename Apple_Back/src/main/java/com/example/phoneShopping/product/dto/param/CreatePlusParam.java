package com.example.phoneShopping.product.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlusParam 
{
	int plusSeq;	// 용량별 추가금액 구분
	int price;		// 추가 금액
	
	public CreatePlusParam(int price)
	{
		this.price=price;
	}
}
