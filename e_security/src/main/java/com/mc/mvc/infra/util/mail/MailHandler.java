package com.mc.mvc.infra.util.mail;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MailHandler {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("mail")
	public String sendMail(@RequestBody Map<String, Object> commandMap, Model model) {
		
		model.addAttribute("data", commandMap);
		return "mail-template/" + commandMap.get("mailTemplate");
	}

}
