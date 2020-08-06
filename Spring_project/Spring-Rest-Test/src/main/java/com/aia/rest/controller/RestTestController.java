package com.aia.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rest.model.Member;

@RestController
@RequestMapping("/rest/v1")
public class RestTestController {
	
	@RequestMapping("/memberMap")
	public Map<Integer,Member> getMap(){
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		map.put(1,new Member(1,"son1","son1@naver.com","cool1.png",new Date()));
		map.put(2,new Member(2,"son2","son2@naver.com","cool2.png",new Date()));
		map.put(3,new Member(3,"son3","son3@naver.com","cool3.png",new Date()));
		map.put(4,new Member(4,"son4","son4@naver.com","cool4.png",new Date()));
		map.put(5,new Member(5,"son5","son5@naver.com","cool5.png",new Date()));
		return map;
	}
	
	@RequestMapping("/memberList")
	public List<Member> getList(){
		
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1,"son1","son1@naver.com","cool1.png",new Date()));
		list.add(new Member(2,"son2","son2@naver.com","cool2.png",new Date()));
		list.add(new Member(3,"son3","son3@naver.com","cool3.png",new Date()));
		list.add(new Member(4,"son4","son4@naver.com","cool4.png",new Date()));
		list.add(new Member(5,"son5","son5@naver.com","cool5.png",new Date()));
		return list;
	}
	// @GetMapping == @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public Member getMember() {
		Member member = new Member();
		member.setId(1);
		member.setName("son");
		member.setEmail("son@naver.com");
		member.setPhoto("default.png");
		
		return member;
	}
	
	@RequestMapping("/text")  // /rest/v1/text
	public String testString() {
		return "Hello~ Restful";
	}
}
