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
@Schema(description = "Payment Product Update Request")
public class UpdatePaymentProductRequest 
{
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "7")
	private int payiSeq;	// 결제 상품 번호
	
	@Schema(description = "Update 결제 상품", example = "i15b512")
	private String prodSeq;	// 결제 상품
	
	@Schema(description = "Update 결제 내역", example = "2")
	private int paySeq;	// 결제 내역
	
	@Schema(description = "Update 결제 가격", example = "2")
	private int payiPrice;	// 결제 가격
	
	@Schema(description = "Update 결제 갯수", example = "2")
	private int payiCount;	// 결제 개수
	
	public UpdatePaymentProductRequest(int paySeq, String prodSeq, int payiPrice, int payiCount)
	{
		this.paySeq=paySeq;
		this.prodSeq=prodSeq;
		this.payiPrice=payiPrice;
		this.payiCount=payiCount;
	}
	
    public int getTotalPrice()
    {
        return payiPrice*payiCount;
    }
}
