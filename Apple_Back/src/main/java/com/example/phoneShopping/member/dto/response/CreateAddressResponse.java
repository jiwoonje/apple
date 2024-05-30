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
@Schema(description = "Create Address response")
public class CreateAddressResponse 
{
	@Schema(description = "Address Create성공 시 response, 반환값 = Integer(생성된 addrSeq)")
	int addrSeq;
}
