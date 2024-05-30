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
@Schema(description = "Color Create Request")
public class CreateColorRequest 
{	
	@NotBlank
	int colorSeq;	// Color 구분
	
	@NotBlank
	@Schema(description = "Update 색깔", example = "aaa")
	String color;	// Color
	
	public CreateColorRequest(String color)
	{
		this.color=color;
	}
}
