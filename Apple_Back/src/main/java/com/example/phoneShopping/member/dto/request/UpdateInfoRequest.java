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
@Schema(description = "Info Update Request")
public class UpdateInfoRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "6")
	private int infoSeq;		// 개인정보 구분 번호
	
	@NotBlank
	@Schema(description = "Update 회원 이름", example = "bbb")
	private String infoName;	// 회원 이름
	
	@NotBlank
	@Schema(description = "Update 회원 생일", example = "2000-02-02")
	private String infoBirth;	// 회원 생일
	
	@NotBlank
	@Schema(description = "Update 회원 성별", example = "Female")
	private String infoGender;	// 회원 성별
	
	@NotBlank
	@Schema(description = "Update 회원 전화번호", example = "010-1111-3333")
	private String infoPhone;	// 회원 전화번호

	public UpdateInfoRequest(String infoName, String infoBirth, String infoGender, String infoPhone)
	{
		this.infoName=infoName;
		this.infoBirth=infoBirth;
		this.infoGender=infoGender;
		this.infoPhone=infoPhone;
	}
}
