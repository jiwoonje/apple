package com.example.phoneShopping.product.dto.param;

import com.example.phoneShopping.product.dto.request.CreateProductRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductParam 
{

	// 상품 일련번호
	private String prodSeq;
	
	// 상품 이름
	private String prodName;
	
	// 상품 가격
	private int prodPrice;
	
	// 재고
	private int prodCnt;
	
	// 옵션 1 : 용량 - FK
	private int hddSeq;
	
	// 옵션 2 : 색상 - FK
	private int colorSeq;

	public CreateProductParam(CreateProductRequest req) 
	{
		this.prodSeq = req.getProdSeq();
		this.prodName = req.getProdName();
		this.prodPrice = req.getProdPrice();
		this.prodCnt = req.getProdCnt();
		this.hddSeq = req.getHddSeq();
		this.colorSeq = req.getColorSeq();
	}
	
}
