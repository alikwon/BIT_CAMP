package com.aia.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.model.Member;
import com.aia.mvc.service.MemberDelService;

@Controller
@RequestMapping("/member/memberDel")
public class MemberDelController {
	
	@Autowired
	private MemberDelService mds;
	
	@RequestMapping(method = RequestMethod.GET)
	public String delConfirm() {
		return "member/memberDelConfirm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String delMember(
						HttpSession session,
						@RequestParam("chkpw")String chkpw,
						Model model) {
		
		Member member = (Member)session.getAttribute("loginInfo");
		int result = mds.delService(member,chkpw,session);
		model.addAttribute("resultDel", result);
		if (result==1)
			session.invalidate();
		return "member/memberDelete";
	}
	
}
