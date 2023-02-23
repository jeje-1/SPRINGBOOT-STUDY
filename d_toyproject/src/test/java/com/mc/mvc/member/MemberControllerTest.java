package com.mc.mvc.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.mc.mvc.module.member.dto.Principal;
import com.mc.mvc.module.member.dto.request.SignUpRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testSignUpFormValidator() throws Exception {
		mockMvc.perform(post("/member/mailauth")
				.param("userId", "testUserWithEmail2")
				.param("password", "1234")
				.param("email", "econoone@gmail.com")
				.param("tell", "010-0119-0112"))
		.andDo(print());
	}
	
	@Test
	@DisplayName("회원가입정보")
	public void testRegistUser() throws Exception {
		
		SignUpRequest form = new SignUpRequest();
		form.setUserId("test");
		form.setPassword("123qwe!@#QWE");
		form.setEmail("econoone@gmail.com");
		form.setTell("010-2222-2222");
		
		mockMvc.perform(get("/member/signupimpl/1234")
				.sessionAttr("signupForm", form)
				.sessionAttr("authToken", "1234"))
			.andExpect(status().is3xxRedirection());
		
	}

}
