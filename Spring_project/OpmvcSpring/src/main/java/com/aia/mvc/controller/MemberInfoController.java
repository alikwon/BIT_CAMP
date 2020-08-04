package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.mvc.model.MemberRegInfo;
import com.aia.mvc.service.IdCheckService;
import com.aia.mvc.service.MemberRegService;

@Controller
@RequestMapping("/member")
public class MemberInfoController {
	@Autowired
	private MemberRegService reg;
	
	@Autowired
	private IdCheckService idCheck;
	
	@RequestMapping(value = "/memberReg",method = RequestMethod.GET)
	public String getMemberRegForm() {
		return "member/regForm";
	}
	
	//동일 아이디가 있는지 체크
	@RequestMapping("/memberReg/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("uid") String uid) {
		return idCheck.checkId(uid);
	}
	
	@RequestMapping(value = "/memberReg",method=RequestMethod.POST)
	public String memberReg(MemberRegInfo info ,
							HttpServletRequest request,
							Model model) {
		
		request = reg.regMember(info, request);
		model.addAttribute("result", request.getAttribute("result"));
		model.addAttribute("member", request.getAttribute("member"));
		return "member/reg";
	}
	
	@RequestMapping("/mypage")
	public String myPage() {
		return "member/mypage";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	
}
