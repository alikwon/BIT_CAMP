package com.aia.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.mvc.model.Member;
import com.aia.mvc.model.MemberXmlList;
import com.aia.mvc.service.MemberJsonListService;
import com.aia.mvc.service.MemberListService;
import com.aia.mvc.service.MemberXmlListService;

@Controller
public class MemberListController {
	
	@Autowired
	MemberListService listService;
	@Autowired
	MemberXmlListService xmlListsv;
	@Autowired
	MemberJsonListService jsonListsv;
	
	@RequestMapping("/member/memberList")
	public String getMemberList(
			Model model, 
			HttpServletRequest request, 
			HttpServletResponse response) throws SQLException{
		
		model.addAttribute("listView", listService.getView(request, response));
		return "/member/memberList";
	}
	
	//xml리스트
	@RequestMapping("/member/memberList.xml")
	@ResponseBody
	public MemberXmlList getMemberXml() {
		
		return xmlListsv.getXmlList();
	}
	
	@RequestMapping("/member/memberList.json")
	@ResponseBody
	public List<Member> getMemberJson(){
		return jsonListsv.getMemberList();
	}
}
