package com.example.phoneShopping.product.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Color Domain")
public class Color
{
	@Schema(description = "색상 구분 번호(자동 생성)")
	int colorSeq;
	
	@Schema(description = "색상")
	String color;
	
	public Color(String color)
	{
		this.color=color;
	}
}
