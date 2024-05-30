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
@Schema(description = "Color Update Request")
public class UpdateColorRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "6")
	int colorSeq;	// Color 구분
	
	@NotBlank
	@Schema(description = "Update 색깔", example = "bbb")
	String color;	// Color
	
	public UpdateColorRequest(String color)
	{
		this.color=color;
	}
}
