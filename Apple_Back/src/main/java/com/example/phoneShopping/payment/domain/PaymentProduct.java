package com.example.phoneShopping.payment.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Payment Product Domain")
public class PaymentProduct 
{
	@Schema(description = "결제 상품 구분 번호")
	private int payiSeq;
	
	@Schema(description = "결제할 상품 번호")
	private String prodSeq;
	
	@Schema(description = "결제 번호")
	private int paySeq;
	
	@Schema(description = "결제할 상품 가격")
	private int payiPrice;
	
	@Schema(description = "결제할 상품의 갯수")
	private int payiCount;
	
	public PaymentProduct(int paySeq, String prodSeq, int payiPrice, int payiCount)
	{
		this.paySeq=paySeq;
		this.prodSeq=prodSeq;
		this.payiPrice=payiPrice;
		this.payiCount=payiCount;
	}

	@Schema(description = "전체 가격을 계산하는 method")
    public int getTotalPrice()
    {
        return payiPrice*payiCount;
    }

}
