package com.example.phoneShopping.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Create Product response")
public class CreateProductResponse 
{
	@Schema(description = "Product Create성공 시 response, 반환값 = String(입력한 prodSeq)")
	private String prodSeq;
}
