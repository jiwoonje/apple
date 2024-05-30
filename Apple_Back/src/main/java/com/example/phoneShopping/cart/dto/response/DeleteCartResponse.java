package com.example.phoneShopping.cart.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Delete Cart response")
public class DeleteCartResponse 
{
	@Schema(description = "Cart Delete성공 시 response, 반환값 = Integer(1 : 성공, 0 : 실패)")
	private int deleteCart;
}
