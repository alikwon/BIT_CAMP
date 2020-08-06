//package com.aia.mvc.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.aia.mvc.model.Member;
//
//@Repository
//public class JdbcTemplateMemberDao {
//	
//	@Inject
//	JdbcTemplate jdbcTemplate;
//	
//	public int selectTotalCnt() throws SQLException {
////		int resultCnt = 0;
//		String sql = "select count(*) from project.member";
////		resultCnt = jdbcTemplate.queryForObject(sql, Integer.class);
////		return resultCnt;
//		return jdbcTemplate.queryForObject(sql, Integer.class);
//	}
//	
//	public List<Member> selectMemberList(int startRow, int mESSAGE_COUNT_PER_PAGE) throws SQLException {
////		List<Member> list = new ArrayList<Member>();
//		String sql = "select idx,uid,upw,uname,uphoto,regdate from project.member limit ?,?";
////		list = jdbcTemplate.query(sql, new Object[] {startRow,mESSAGE_COUNT_PER_PAGE},new MemberRowMapper());
//		return jdbcTemplate.query(sql, new Object[] {startRow,mESSAGE_COUNT_PER_PAGE},new MemberRowMapper());
//	}
//	
//	public int insertMemeber(Member member) throws SQLException {
//		int resultCnt=0;
//		String sql="INSERT INTO project.member " + 
//					"(uid,upw,uname,uphoto) " + 
//				   "VALUES " + 
//				   	"(?,?,?,?);";
//		resultCnt = jdbcTemplate.update(
//									sql, 
//									member.getUid(),
//									member.getUpw(),
//									member.getUname(),
//									member.getUphoto());
//		return resultCnt;
//	}
//	
//	public int selectById(String id) throws SQLException {
//		String sql = "select count(*) from project.member where uid=?";
//		return jdbcTemplate.queryForObject(sql, Integer.class, id);
//	}
//	
//	
//	public Member logincheck(String uid, String upw) throws SQLException {
//		Member member =null;
//		String sql = "select * from project.member where uid=? and upw=?";
//		member = jdbcTemplate.queryForObject(sql, new Object[] {uid,upw}, new MemberRowMapper());
//		return member;
//	}
//	
//	public int deleteMember(int idx) throws SQLException{
//		String sql = "delete from project.member where idx=?";
//		return jdbcTemplate.update(sql, idx);
//	}
//	
//	public int editMemeber(Member member) throws SQLException{
//		int resultCnt=0;
//		String sql = "update project.member set upw=?,uname=?,uphoto=? where uid=?";
//		resultCnt = jdbcTemplate.update(sql, member.getUpw(),member.getUname(),member.getUphoto(),member.getUid());
//		return resultCnt;
//	}
//}
