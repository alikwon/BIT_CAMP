package com.aia.mvc.service;


import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.Member;

@Component
public class LoginCheckService2 {

//	@Autowired
//	private JdbcTemplateMemberDao dao;

	private MemberDaoInterface dao;

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public Member loginResult(Member mb, HttpServletRequest request) {
		String uid = mb.getUid();
		String upw = mb.getUpw();
		Member member = null;
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		member = dao.logincheck(uid, upw);

		return member;
	}

}
