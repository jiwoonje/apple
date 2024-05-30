package com.example.phoneShopping.product.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Product Create Request")
public class CreateProductRequest 
{

	// 상품 일련번호
	@NotBlank
	@Schema(description = "상품 일련번호, 직접 등록", example = "19th")
	private String prodSeq;
	
	// 상품 이름
	@NotBlank
	@Schema(description = "Create 상품 이름", example = "aaa")
	private String prodName;
	
	// 상품 가격
	@NotBlank
	@Schema(description = "Create 상품 가격", example = "1")
	private int prodPrice;
	
	// 재고
	@NotBlank
	@Schema(description = "Create 상품 재고", example = "1")
	private int prodCnt;
	
	// 옵션 1 : 용량 - FK
	@NotBlank
	@Schema(description = "Create 상품 용량", example = "1")
	private int hddSeq;
	
	// 옵션 2 : 색상 - FK
	@NotBlank
	@Schema(description = "Create 상품 색상", example = "1")
	private int colorSeq;
	
}