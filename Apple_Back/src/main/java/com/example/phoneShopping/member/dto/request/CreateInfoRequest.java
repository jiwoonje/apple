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
@Schema(description = "Info Create Request")
public class CreateInfoRequest 
{
	@NotBlank
	private int infoSeq;		// 개인정보 구분 번호
	
	@NotBlank
	@Schema(description = "Create 회원 이름", example = "aaa")
	private String infoName;	// 회원 이름
	
	@NotBlank
	@Schema(description = "Create 회원 생일", example = "2000-01-01")
	private String infoBirth;	// 회원 생일
	
	@NotBlank
	@Schema(description = "Create 회원 성별", example = "Male")
	private String infoGender;	// 회원 성별
	
	@NotBlank
	@Schema(description = "Create 회원 전화번호", example = "010-1111-2222")
	private String infoPhone;	// 회원 전화번호

	public CreateInfoRequest(String infoName, String infoBirth, String infoGender, String infoPhone)
	{
		this.infoName=infoName;
		this.infoBirth=infoBirth;
		this.infoGender=infoGender;
		this.infoPhone=infoPhone;
	}
}
