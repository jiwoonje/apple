package com.example.phoneShopping.payment.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Create Payment response")
public class CreatePaymentResponse 
{
	@Schema(description = "Payment Create성공 시 response, 반환값 = Integer(생성된 paySeq)")
	private int paySeq;	// 결제 번호
}
