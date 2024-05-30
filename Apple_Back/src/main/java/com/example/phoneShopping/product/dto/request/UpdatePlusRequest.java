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
@Schema(description = "Plus Update Request")
public class UpdatePlusRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "3")
	int plusSeq;	// 용량별 추가금액 구분
	
	@NotBlank
	@Schema(description = "Update 추가금액", example = "2")
	int price;		// 추가 금액
	
	public UpdatePlusRequest(int price)
	{
		this.price=price;
	}
}
