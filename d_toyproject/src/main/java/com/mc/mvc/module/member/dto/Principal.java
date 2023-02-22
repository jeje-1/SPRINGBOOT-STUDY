package com.mc.mvc.module.member.dto;

import com.mc.mvc.module.member.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Principal {
	
	public Principal(Member member) {
		this.userId = member.getUserId();
		this.password = member.getPassword();
		this.email = member.getEmail();
		this.tell  = member.getTell();
	}
	private String userId;
	private String password;
	private String email;
	private String tell;
}
