package com.example.phoneShopping.member.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberParam 
{
	private int memSeq;	// 회원 구분 번호
	private String memId;	// 회원 ID
	private String memPw;	// 회원 PW
	private String checkMemPw;	// 회원 PW
	
	public UpdateMemberParam(String memId, String memPw, String checkMemPw)
	{
		this.memId=memId;
		this.memPw=memPw;
		this.checkMemPw=checkMemPw;
	}
	
	public UpdateMemberParam(String memPw, String checkMemPw)
	{
		this.memPw=memPw;
		this.checkMemPw=checkMemPw;
	}
}
