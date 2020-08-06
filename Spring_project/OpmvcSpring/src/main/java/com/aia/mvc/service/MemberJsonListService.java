package com.aia.mvc.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.Member;

@Service
public class MemberJsonListService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate st;
	
	public List<Member>getMemberList(){
		dao = st.getMapper(MemberDaoInterface.class);
		return dao.selectTotalList();
	}
}
