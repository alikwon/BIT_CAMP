package com.aia.mm.dao;

import java.util.List;

import com.aia.mm.model.Member;


public interface MemberDao {

	public List<Member> selectList();

	public int insertMember(Member member);

	public Member selectByIdx(int idx);

	public int editMember(Member member);

	public int deleteMember(int idx);


}
