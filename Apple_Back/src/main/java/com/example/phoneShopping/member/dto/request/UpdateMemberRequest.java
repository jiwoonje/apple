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
@Schema(description = "member update request")
public class UpdateMemberRequest 
{
	@NotBlank
	@Schema(description = "DB내에 존재하는 아이디 확인, 실제 변경X", example = "example")
	private String memId;	// 회원 ID
	
	@NotBlank
	@Schema(description = "Update PW", example = "example")
	private String memPw;	// 회원 PW
	
	@NotBlank
	@Schema(description = "Check Update PW", example = "example")
	private String checkMemPw;	// 회원 PW
}
