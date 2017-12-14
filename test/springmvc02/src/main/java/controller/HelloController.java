package controller;

import java.util.HashMap;
import java.util.Map; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login1(HttpServletRequest request){
		System.out.println("login1()");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		System.out.println(username + "  "  + pwd);
		return "index";
	}

	@RequestMapping("/login2.do")
	public String login2(String username,@RequestParam("pwd") String password){
		System.out.println("login2()");
		
		System.out.println(username + "  "  + password);
		return "index";
	}
	
	@RequestMapping("/login3.do")
	public String login3(AdminParam ap){
		System.out.println("login3()");
		
		System.out.println(ap.getUsername() + "  "  + ap.getPwd());
		return "index";
	}
	
	@RequestMapping("/login4.do")
	public String login4(AdminParam ap,HttpServletRequest request){
		System.out.println("login4()");
		String username=ap.getUsername();
		//�����ݰ󶨵�request
		request.setAttribute("username", username);
		//springmvcĬ��ʹ��ת��
		return "index";
	}
	
	@RequestMapping("/login5.do")
	//��ҳ�洫ֵ�ĵڶ��ַ�ʽ
	//ʹ��ModerAndView
	public ModelAndView login5(AdminParam ap){
		System.out.println("login5()");
		String username=ap.getUsername();
		System.out.println(username);
		Map<String, Object> data = new HashMap<String,Object>();
		//�൱��requestsetAttribute("username",username);
		data.put("username", username);
		//����ModerAndView����
		ModelAndView mav = new ModelAndView("index",data);
		return mav;
	}
	
	@RequestMapping("/login6.do")
	public String login6(AdminParam ap,ModelMap mm){
		System.out.println("login6()");
		String username=ap.getUsername();
		System.out.println(username);
		//�൱��requestsetAttribute("username",username);
		mm.addAttribute("username",username);
		return "index";
	}
	
	@RequestMapping("/login7.do")
	//��ҳ�洫ֵ�ĵ����ַ�ʽ
	//ʹ��session
	public String login7(AdminParam ap,HttpSession session){
		System.out.println("login7()");
		String username=ap.getUsername();
		System.out.println(username);
		session.setAttribute("username", username);
		return "index"; 
	}
	
	@RequestMapping("/login8.do")
	public String login8(){
		System.out.println("login8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	
	@RequestMapping("/login9.do")
	public ModelAndView login9(){
		System.out.println("login9()");
		RedirectView rv = new RedirectView("toIndex.do");
		return new ModelAndView(rv);
	}
}