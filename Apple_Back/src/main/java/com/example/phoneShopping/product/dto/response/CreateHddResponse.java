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
@Schema(description = "Create Hdd response")
public class CreateHddResponse 
{
	@Schema(description = "Hdd Create성공 시 response, 반환값 = Integer(생성된 hddSeq)")
	int hddSeq;	// HDD 구분
}
