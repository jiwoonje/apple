package com.example.phoneShopping.product.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Plus Create Request")
public class CreatePlusRequest 
{
	@NotBlank
	int plusSeq;	// 용량별 추가금액 구분
	
	@NotBlank
	@Schema(description = "Update 추가금액", example = "1")
	int price;		// 추가 금액
	
	public CreatePlusRequest(int price)
	{
		this.price=price;
	}
}
