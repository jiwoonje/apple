package com.example.phoneShopping.product.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Product Domain")
public class Product
{
	@Schema(description = "상품 일련번호")
	private String prodSeq;

	@Schema(description = "상품 이름")
	private String prodName;

	@Schema(description = "상품 가격")
	private int prodPrice;

	@Schema(description = "상품 재고")
	private int prodCnt;
	
	@Schema(description = "상품의 디스크 크기(용량)")
	private int hddSeq;
	
	@Schema(description = "상품의 색상")
	private int colorSeq;
}
