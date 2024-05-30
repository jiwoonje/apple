package com.example.phoneShopping.payment.domain;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Payment Domain")
public class Payment 
{
	@Schema(description = "결제 번호(자동 생성)")
	private int paySeq;
	
	@Schema(description = "결제자")
	private int memSeq;
	
	@Schema(description = "결제 시간")
	private LocalDateTime payDate;
	
	@Schema(description = "결제 상태(1 : 결제완료, 0 : 환불)")
	private int payStatus;

	public Payment(int memSeq, LocalDateTime payDate, int payStatus)
	{
		this.memSeq=memSeq;
		this.payDate=payDate;
		this.payStatus=payStatus;
	}
}
