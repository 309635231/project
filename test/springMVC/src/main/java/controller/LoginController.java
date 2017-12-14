package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Admin;
import service.ApplicationException;
import service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService service;
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin.()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		System.out.println("login()");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		System.out.println(username + "  " + pwd);
		request.setAttribute("user", username);
		try {
			Admin admin=service.checkLogin(username, pwd);
			session.setAttribute("admin", admin);
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException){
				request.setAttribute("login_failed", e.getMessage());
				return "login";
			}
			return "error";
		}

		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
}
