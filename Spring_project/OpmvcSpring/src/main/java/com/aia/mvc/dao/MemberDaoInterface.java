package com.aia.mvc.dao;

import java.util.List;
import java.util.Map;

import com.aia.mvc.model.Member;
import com.aia.mvc.model.MemberXML;

public interface MemberDaoInterface {
	
	//전체 XML회원리스트
	public List<MemberXML> selectTotalXmlList();

	//회원 idx기반으로 검색한 회원의 정보를 반환
	public Member selectByIdx(int idx);
	//로그인
	public Member logincheck(String uid,String upw);
	//회원가입
	public int insertMember(Member member);
	//회원삭제
	public int deleteMember(int idx);
	//회원수정
	public int editMemeber(Member member);
	//동일아이디검사
	public int selectById(String id);
	//전체게시물개수 : 검색까지 포함
	public int totalCount(Map search);
	//전체게시물의 리스트
	public List<Member> selectList(Map search);
	
	
}
