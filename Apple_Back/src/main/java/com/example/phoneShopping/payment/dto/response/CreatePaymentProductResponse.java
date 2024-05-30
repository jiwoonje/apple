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
@Schema(description = "Create Payment Product response")
public class CreatePaymentProductResponse 
{
	@Schema(description = "Payment Product Create성공 시 response, 반환값 = Integer(생성된 payiSeq)")
	private int payiSeq;	// 결제 상품 번호
}
