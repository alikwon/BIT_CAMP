package com.aia.mvc.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDaoInterface;

@Component("idCheck")
public class IdCheckService {

//	@Autowired
//	private JdbcTemplateMemberDao dao;

	private MemberDaoInterface dao;

	@Autowired
	private SqlSessionTemplate st;

	public String checkId(String uid) {
		dao = st.getMapper(MemberDaoInterface.class);
		String result = "N";

		int resultCnt = dao.selectById(uid);
		if (resultCnt < 1) {
			result = "Y";
		}

		return result;
	}

}