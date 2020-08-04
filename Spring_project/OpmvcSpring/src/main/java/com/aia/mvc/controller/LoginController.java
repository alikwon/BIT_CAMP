package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.model.Member;
import com.aia.mvc.service.LoginCheckService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	private LoginCheckService login;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginResult(
						Member member,
						HttpServletRequest request,
						HttpSession session,
						Model model) {
		member = login.loginResult(member,request);
		session.setAttribute("loginInfo", member);
		if (member !=null) {
			model.addAttribute("loginChk",1);
			model.addAttribute("uid",member.getUid());
		} else {
			model.addAttribute("loginChk",0);
		}
		
		return "member/login";
	}

}
