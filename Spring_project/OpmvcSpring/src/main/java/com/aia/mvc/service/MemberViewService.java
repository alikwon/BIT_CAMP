package com.aia.mvc.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.Member;

@Service
public class MemberViewService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate st;
	
	public Member getMemberInfo(int idx) {
		dao = st.getMapper(MemberDaoInterface.class);
		return dao.selectByIdx(idx);
	}
}
