package com.example.phoneShopping.product.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Plus Domain")
public class Plus 
{
	@Schema(description = "용량별 추가금액 구분 번호(자동 생성)")
	int plusSeq;
	
	@Schema(description = "추가 금액")
	int price;
	
	public Plus(int price)
	{
		this.price=price;
	}
}
