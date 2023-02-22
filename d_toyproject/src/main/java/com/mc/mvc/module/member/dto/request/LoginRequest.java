package com.mc.mvc.module.member.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
	
	@NotBlank(message="userId가 공백입니다.")
	private String userId;
	
	@NotBlank(message="password가 공백입니다.")
	private String password;
}
