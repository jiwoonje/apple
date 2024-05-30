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
@Schema(description = "Info Domain")
public class Info 
{
	@Schema(description = "개인정보 구분 번호(자동 생성)")
	private int infoSeq;
	
	@Schema(description = "회원 이름")
	private String infoName;
	
	@Schema(description = "회원 생일")
	private String infoBirth;
	
	@Schema(description = "회원 성별")
	private String infoGender;
	
	@Schema(description = "회원 전화번호")
	private String infoPhone;
	
	public Info(String infoName, String infoBirth, String infoGender, String infoPhone)
	{
		this.infoName=infoName;
		this.infoBirth=infoBirth;
		this.infoGender=infoGender;
		this.infoPhone=infoPhone;
	}
}
