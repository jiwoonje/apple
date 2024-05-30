package com.example.phoneShopping.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@Schema(description = "Member Domain")
public class Member 
{
	@Schema(description = "회원 구분 번호(자동 생성)")
	private int memSeq;
	
	@Schema(description = "회원 ID")
	private String memId;
	
	@Schema(description = "회원 PW")
	private String memPw;
	
	public Member(String memId, String memPw)
	{
		this.memId=memId;
		this.memPw=memPw;
	}
}
