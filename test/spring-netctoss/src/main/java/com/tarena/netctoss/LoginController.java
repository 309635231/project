package com.tarena.netctoss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin.()");
		return "login";
	}
	
	
}
