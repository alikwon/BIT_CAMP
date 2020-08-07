package com.mm.aa.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.aa.dao.MemberDao;
import com.mm.aa.model.Member;

@Service
public class MemberListService {
	
	@Autowired
	private SqlSessionTemplate st;
	private MemberDao dao;
	
	public List<Member> getMemberList(){
		dao = st.getMapper(MemberDao.class);
		return dao.selectList();
	}
}
