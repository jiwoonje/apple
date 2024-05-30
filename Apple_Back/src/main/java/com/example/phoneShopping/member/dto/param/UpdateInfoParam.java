package com.example.phoneShopping.member.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInfoParam 
{
	private int infoSeq;		// 개인정보 구분 번호
	private String infoName;	// 회원 이름
	private String infoBirth;	// 회원 생일
	private String infoGender;	// 회원 성별
	private String infoPhone;	// 회원 전화번호
	
	public UpdateInfoParam(String info_name, String info_birth, String info_gender, String info_phone)
	{
		this.infoName=info_name;
		this.infoBirth=info_birth;
		this.infoGender=info_gender;
		this.infoPhone=info_phone;
	}
}
