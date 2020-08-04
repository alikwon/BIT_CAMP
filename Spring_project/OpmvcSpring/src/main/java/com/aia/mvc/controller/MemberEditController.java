package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.model.MemberRegInfo;
import com.aia.mvc.service.MemberEditService;

@Controller
@RequestMapping("/member/memberEdit")
public class MemberEditController {
	
	@Autowired
	private MemberEditService editsv;
	
	@RequestMapping(method = RequestMethod.GET)
	public String memberEditForm() {
		return "member/memberEditForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberEdit(
						Model model,
						HttpServletRequest request,
						MemberRegInfo info
						) {
		String oldimg = request.getParameter("oldphoto");
		model.addAttribute("result",editsv.getViewPage(request, info, oldimg));
		return "member/memberEdit";
	}
	
	
}
