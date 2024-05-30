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
@Schema(description = "Create Plus response")
public class CreatePlusResponse 
{
	@Schema(description = "Plus Create성공 시 response, 반환값 = Integer(생성된 plusSeq)")
	int plusSeq;	// 용량별 추가금액 구분
}
