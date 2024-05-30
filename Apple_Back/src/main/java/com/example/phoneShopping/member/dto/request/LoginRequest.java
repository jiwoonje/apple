package com.example.phoneShopping.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "member login request")
public class LoginRequest 
{
	@NotBlank
	@Schema(description = "login ID", example = "admin")
	private String memId;	// 회원 ID
	
	@NotBlank
	@Schema(description = "login PW", example = "admin")
	private String memPw;	// 회원 PW

}
