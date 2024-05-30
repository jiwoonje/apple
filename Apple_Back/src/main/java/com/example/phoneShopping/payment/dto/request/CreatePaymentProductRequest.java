package com.example.phoneShopping.payment.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Payment Product Create Request")
public class CreatePaymentProductRequest 
{
	private int payiSeq;	// 결제 상품 번호
	
	@Schema(description = "Create 결제 상품", example = "i15b256")
	private String prodSeq;	// 결제 상품
	
	@Schema(description = "Create 결제 내역", example = "1")
	private int paySeq;	// 결제 내역
	
	@Schema(description = "Create 결제 가격", example = "1")
	private int payiPrice;	// 결제 가격
	
	@Schema(description = "Create 결제 개수", example = "1")
	private int payiCount;	// 결제 개수
	
	public CreatePaymentProductRequest(String prodSeq, int paySeq, int payiPrice, int payiCount)
	{
		this.prodSeq=prodSeq;
		this.paySeq=paySeq;
		this.payiPrice=payiPrice;
		this.payiCount=payiCount;
	}
	
    public int getTotalPrice()
    {
        return payiPrice*payiCount;
    }
}
