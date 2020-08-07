package com.mm.aa.dao;

import java.util.List;

import com.mm.aa.model.Member;

public interface MemberDao {

	public List<Member> selectList();

	public int insertMember(Member member);

	public Member selectByIdx(int idx);

	public int editMember(Member member);

	public int deleteMember(int idx);


}
