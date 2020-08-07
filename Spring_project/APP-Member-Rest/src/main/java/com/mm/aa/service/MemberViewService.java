package com.mm.aa.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.aa.dao.MemberDao;
import com.mm.aa.model.Member;

@Service
public class MemberViewService {

	@Autowired
	private SqlSessionTemplate st;
	private MemberDao dao;
	
	public Member getMember(int idx) {
		dao = st.getMapper(MemberDao.class);
		return dao.selectByIdx(idx);
	}
}
