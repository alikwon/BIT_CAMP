package com.aia.mvc.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.model.LoginInfo;

@Controller
@RequestMapping("/login/login")
//http://localhost:8080/mvc/login/login
public class LoginController {
	
	//GET방식의 요청 --> LoginForm 페이지
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {
		return "login/loginForm"; 
		// /WEB-INF/views/login/loginForm.jsp
	}
	
	//POST방식의 요청 --> Login처리 페이지
	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpServletRequest request,
						@RequestParam("uid") String userId,
						@RequestParam("upw") String userPw,
						@ModelAttribute("login") LoginInfo loginInfo,
						Model model) {
		
		//1. HttpServletRequest 사용
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		System.out.println("----------------------");
		System.out.println(uid);
		System.out.println(upw);
		//2.@RequestParam 사용
		System.out.println("----------------------");
		System.out.println(userId);
		System.out.println(userPw);
		
		//3.model(LoginRequest)를 이용
		System.out.println("----------------------");
		System.out.println(loginInfo.getUid());
		System.out.println(loginInfo.getUpw());
		
		System.out.println(model.toString());
//		request.setAttribute("uid", uid);
//		request.setAttribute("upw", upw);
		return "login/login";
	}
	
}
