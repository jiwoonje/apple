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
@Schema(description = "Hdd Create Request")
public class CreateHddRequest 
{
	@NotBlank
	int hddSeq;	// HDD 구분
	
	@NotBlank
	@Schema(description = "Create HDD용량", example = "1")
	int capacity;	// HDD 용량
	
	@NotBlank
	@Schema(description = "Create 추가 금액", example = "1")
	int plusSeq;	// HDD용량에 따른 추가 금액
	
	public CreateHddRequest(int capacity, int plusSeq)
	{
		this.capacity=capacity;
		this.plusSeq=plusSeq;
	}
}
