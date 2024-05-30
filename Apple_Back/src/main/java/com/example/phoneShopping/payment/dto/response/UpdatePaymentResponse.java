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
@Schema(description = "Update Payment response")
public class UpdatePaymentResponse 
{
	@Schema(description = "Payment Update성공 시 response, 반환값 = Integer(1 : 성공, 0 : 실패)")
	private int updatedPayment;
}
