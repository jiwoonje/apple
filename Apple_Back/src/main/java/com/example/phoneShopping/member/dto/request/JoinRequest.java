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
@Schema(description = "member create request")
public class JoinRequest 
{
	@NotBlank
	@Schema(description = "Create ID", example = "example")
	private String memId;	// 회원 ID
	
	@NotBlank
	@Schema(description = "Create PW", example = "example")
	private String memPw;	// 회원 PW
	
	@NotBlank
	@Schema(description = "Check Create PW", example = "example")
	private String checkMemPw;	// 회원 PW
}
