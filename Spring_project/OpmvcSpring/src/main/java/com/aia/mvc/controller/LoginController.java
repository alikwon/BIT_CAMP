package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.service.Service;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	Service login;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginResult(HttpServletRequest request,HttpServletResponse response ) {
		return login.getViewPage(request, response);
	}

}
