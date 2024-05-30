package com.example.phoneShopping.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Update Address response")
public class UpdateAddressResponse 
{
	@Schema(description = "Address Update성공 시 response, 반환값 = Integer(1 : 성공, 0 : 실패)")
	private int updatedAddress;
}
