package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.CreateInfoRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInfoParam 
{
	private int infoSeq;		// 개인정보 구분 번호
	private String infoName;	// 회원 이름
	private String infoBirth;	// 회원 생일
	private String infoGender;	// 회원 성별
	private String infoPhone;	// 회원 전화번호
	
	public CreateInfoParam(CreateInfoRequest req)
	{
		this.infoName=req.getInfoName();
		this.infoBirth=req.getInfoBirth();
		this.infoGender=req.getInfoGender();
		this.infoPhone=req.getInfoPhone();
	}
}
