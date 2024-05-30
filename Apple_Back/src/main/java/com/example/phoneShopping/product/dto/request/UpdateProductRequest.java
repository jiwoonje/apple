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
@Schema(description = "Product Update Request")
public class UpdateProductRequest 
{
	// 상품 일련번호
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "19th")
	private String prodSeq;
	
	// 상품 이름
	@NotBlank
	@Schema(description = "Update 상품 이름", example = "bbb")
	private String prodName;
	
	// 상품 가격
	@NotBlank
	@Schema(description = "Update 상품 가격", example = "2")
	private int prodPrice;
	
	// 재고
	@NotBlank
	@Schema(description = "Update 상품 재고", example = "2")
	private int prodCnt;
	
	// 옵션 1 : 용량 - FK
	@NotBlank
	@Schema(description = "Update 상품 용량", example = "2")
	private int hddSeq;
	
	// 옵션 2 : 색상 - FK
	@NotBlank
	@Schema(description = "Update 상품 색상", example = "2")
	private int colorSeq;
	
	public UpdateProductRequest(String prodName, int prodPrice, int prodCnt, int hddSeq, int colorSeq)
	{
		this.prodName=prodName;
		this.prodPrice=prodPrice;
		this.prodCnt=prodCnt;
		this.hddSeq=hddSeq;
		this.colorSeq=colorSeq;
	}

}
