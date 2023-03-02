package com.mc.mvc.module.member.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mc.mvc.module.member.MemberRepository;
import com.mc.mvc.module.member.dto.request.SignUpRequest;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SignUpValidator implements Validator{
	
	private MemberRepository memberRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SignUpRequest form = (SignUpRequest) target;
		
		if(memberRepository.existsById(form.getUserId())) {
			errors.rejectValue("userId", "error.userId","이미 존재하는 아이디 입니다.");
		}
		
		// 비밀번호가 8글자 이상의 숫자, 영문자, 특수문자 조합인지 확인
		if(!Pattern.compile("(?!.*[ㄱ-힣])(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9ㄱ-힣])(?=.{8,})").matcher(form.getPassword()).find()) {
			errors.rejectValue("password", "password.format", "비밀번호는 8글자 이상의 숫자, 영문자, 특수문자의 조합이어야 합니다.");
		}
		
		// 존재하는 이메일인지 확인
//		if(memberRepository.selectMemberByEmail(form.getEmail()) != null) {
//			errors.rejectValue("email", "exist.email", "이미 존재하는 이메일입니다.");
//		}
	}

}
