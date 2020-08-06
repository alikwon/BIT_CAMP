package com.aia.mvc.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.MemberXML;
import com.aia.mvc.model.MemberXmlList;

public class MemberXmlListService {
	
	private MemberDaoInterface dao;
	@Autowired
	private SqlSessionTemplate st;

	public MemberXmlList getXmlList() {
		dao = st.getMapper(MemberDaoInterface.class);
		List<MemberXML> memberList = dao.selectTotalXmlList();
		MemberXmlList list = new MemberXmlList(memberList);
		return list;
//		return new MemberXmlList(dao.selectTotalXmlList());
	}
}
