package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aia.mvc.model.MemberRegInfo;
import com.aia.mvc.service.MemberRegService;
import com.aia.mvc.service.Service;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMemberRegForm() {
		return "member/regForm";
	}
	
	@Autowired
	Service idCheck;
	@RequestMapping("/idCheck")
	public String idCheck(HttpServletRequest request, HttpServletResponse response) {
		return idCheck.getViewPage(request, response);
	}
	
	@Autowired
	MemberRegService reg;
	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(MemberRegInfo info ,
							HttpServletRequest request,
							Model model) {
		
		request = reg.regMember(info, request);
		System.out.println("반환한 리퀘스트의 result : "+request.getAttribute("result"));
		System.out.println("반환한 리퀘스트의 member : "+request.getAttribute("member"));
		model.addAttribute("result", request.getAttribute("result"));
		model.addAttribute("member", request.getAttribute("member"));
		return "member/reg";
	}
	
	
	
}
