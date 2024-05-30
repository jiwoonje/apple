package com.example.phoneShopping.payment.dto.request;

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
@Schema(description = "Payment Update Request")
public class UpdatePaymentRequest 
{
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "6")
	private int paySeq;	// 결제 번호
	
	@Schema(description = "Update 결제자", example = "2")
	private int memSeq;	// 결제자
	
	@Schema(description = "Update 결제일", example = "날짜")
	private LocalDateTime payDate;	// 결제일
	
	@Schema(description = "Update 결제 상태", example = "1")
	private int payStatus;	// 결제 상태
	
	public UpdatePaymentRequest(int memSeq, LocalDateTime payDate, int payStatus)
	{
		this.memSeq=memSeq;
		this.payDate=payDate;
		this.payStatus=payStatus;
	}
}
