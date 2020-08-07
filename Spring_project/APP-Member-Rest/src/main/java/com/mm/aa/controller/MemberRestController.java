package com.mm.aa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.aa.model.Member;
import com.mm.aa.model.MemberEditInfo;
import com.mm.aa.model.MemberRegInfo;
import com.mm.aa.service.MemberDelService;
import com.mm.aa.service.MemberEditService;
import com.mm.aa.service.MemberListService;
import com.mm.aa.service.MemberRegService;
import com.mm.aa.service.MemberViewService;

@RestController
@RequestMapping("/members")
public class MemberRestController {
	
	@Autowired
	MemberListService listsv;
	@Autowired
	MemberRegService regsv;
	@Autowired
	MemberViewService mvsv;
	@Autowired
	MemberEditService editsv;
	@Autowired
	MemberDelService delsv;
	//회원리스트 : JSON으로 응답
	@GetMapping		//GET|	/members
	public List<Member> getMemberList(){
		return listsv.getMemberList();
	}
	
	//가입 결과
	@PostMapping	//POST|	/members
	public int reg(MemberRegInfo info,HttpServletRequest req) {
		return regsv.regMember(info,req);
	}
	
	//1명의 회원의 정보출력
	@GetMapping("{idx}")	//GET|	/members/{idx}
	public Member getMember(@PathVariable("idx")int idx) {
		return mvsv.getMember(idx);
	}
	
	//1명의 회원정보 수정
	@PostMapping("/{idx}")	//PUT|	/members/{idx}
	public int edit(
				@PathVariable("idx")int idx,
				MemberEditInfo info,
				HttpServletRequest req
			) {
		info.setIdx(idx);
		return editsv.editMember(req, info);
	}
	
	//회원삭제
	@DeleteMapping("/{idx}")//DELETE|	/members/{idx}
	public int delete(
				@PathVariable("idx") int idx,
				HttpServletRequest req) {
		return delsv.deleteMember(idx,req);
	}
}
