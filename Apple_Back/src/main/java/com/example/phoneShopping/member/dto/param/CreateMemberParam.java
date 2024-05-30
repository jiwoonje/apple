package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.JoinRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberParam 
{
	private int memSeq;	// 회원 구분 번호
	private String memId;	// 회원 ID
	private String memPw;	// 회원 PW
	
	public CreateMemberParam(JoinRequest req, String encodedPwd)
	{
		this.memId=req.getMemId();
		this.memPw=encodedPwd;
	}
}
