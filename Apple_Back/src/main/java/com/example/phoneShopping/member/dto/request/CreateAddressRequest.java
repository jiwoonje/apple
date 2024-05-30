package com.example.phoneShopping.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Address Create Request")
public class CreateAddressRequest 
{
	@NotBlank
	private int addrSeq;	// 주소 구분 번호
	
	@NotBlank
	@Schema(description = "Create 우편번호", example = "aaa")
	private String addrZip;	// 주소 우편번호
	
	@NotBlank
	@Schema(description = "Create 상세 주소", example = "aaa")
	private String addrDetail;	// 주소 상세
	
	public CreateAddressRequest(String addrZip, String addrDetail)
	{
		this.addrZip=addrZip;
		this.addrDetail=addrDetail;
	}
}
