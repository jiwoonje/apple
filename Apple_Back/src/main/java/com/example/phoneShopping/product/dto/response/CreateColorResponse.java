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
@Schema(description = "Create Color response")
public class CreateColorResponse 
{
	@Schema(description = "Color Create성공 시 response, 반환값 = Integer(생성된 colorSeq)")
	int colorSeq;	// Color 구분
}
