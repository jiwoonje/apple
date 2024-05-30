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
@Schema(description = "Address Update Request")
public class UpdateAddressRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "6")
	private int addrSeq;	// 주소 구분 번호
	
	@NotBlank
	@Schema(description = "Update 우편번호", example = "bbb")
	private String addrZip;	// 주소 우편번호
	
	@NotBlank
	@Schema(description = "Update 상세 주소", example = "bbb")
	private String addrDetail;	// 주소 상세
	
	public UpdateAddressRequest(String addrZip, String addrDetail)
	{
		this.addrZip=addrZip;
		this.addrDetail=addrDetail;
	}
}
