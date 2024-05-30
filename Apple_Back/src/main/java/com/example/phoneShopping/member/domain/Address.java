package com.example.phoneShopping.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Address Domain")
public class Address 
{
	@Schema(description = "주소 구분 번호(자동 생성)")
	private int addrSeq;
	
	@Schema(description = "우편번호")
	private String addrZip;
	
	@Schema(description = "상세주소")
	private String addrDetail;
	
	public Address(String addrZip, String addrDetail)
	{
		this.addrZip=addrZip;
		this.addrDetail=addrDetail;
	}
}
