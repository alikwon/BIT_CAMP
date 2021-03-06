package com.aia.mvc.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.Member;

@Component
public class LoginCheckService{
	
//	@Autowired
//	private JdbcTemplateMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate st;
	
	public Member loginResult(Member mb, HttpServletRequest request) {
		dao= st.getMapper(MemberDaoInterface.class);
		String uid = mb.getUid();
		String upw = mb.getUpw();
		Member member = null;
		try {
			member = dao.logincheck(uid,upw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

}
