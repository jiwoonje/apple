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
@Schema(description = "Hdd Update Request")
public class UpdateHddRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "3")
	int hddSeq;	// HDD 구분
	
	@NotBlank
	@Schema(description = "Update HDD용량", example = "2")
	int capacity;	// HDD 용량
	
	@NotBlank
	@Schema(description = "Update 추가 금액", example = "2")
	int plusSeq;	// HDD용량에 따른 추가 금액
	
	public UpdateHddRequest(int capacity, int plusSeq)
	{
		this.capacity=capacity;
		this.plusSeq=plusSeq;
	}
}
