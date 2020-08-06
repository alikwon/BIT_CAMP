package com.aia.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.mvc.service.MemberViewService;

@Controller
public class MemberViewController {
	
	@Autowired
	private MemberViewService service;
	//http://localhost:8080/OpmvcSpring/member/view/12
	@RequestMapping("/member/view/{no}")
	public String getMemberInfo(
							@PathVariable("no") int idx,
							Model model) {
		model.addAttribute("member", service.getMemberInfo(idx));
		return "member/memberView";
	}
}
