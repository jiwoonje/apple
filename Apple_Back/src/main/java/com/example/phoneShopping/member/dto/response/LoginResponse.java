package com.example.phoneShopping.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "member login response")
public class LoginResponse 
{
	@Schema(description = "login시 사용하는 JWT")
    private String jwt;
	
	@Schema(description = "login시 사용하는 ID")
    private String memId;
}
