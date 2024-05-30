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
@Schema(description = "Hdd Domain")
public class Hdd 
{
	@Schema(description = "HDD 구분 번호(자동 생성)")
	int hddSeq;
	
	@Schema(description = "HDD 용량")
	int capacity;
	
	@Schema(description = "HDD용량에 따른 추가 금액")
	int plusSeq;
	
	public Hdd(int capacity, int plusSeq)
	{
		this.capacity=capacity;
		this.plusSeq=plusSeq;
	}
}
