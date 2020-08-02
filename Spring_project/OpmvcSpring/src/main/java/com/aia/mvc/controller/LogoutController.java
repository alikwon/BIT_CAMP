package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.mvc.service.Service;

@Controller
public class LogoutController {

	@Autowired
	Service logout;
	
	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return logout.getViewPage(request, response);
	}
}
