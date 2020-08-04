package com.aia.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aia.mvc.model.Member;

@Repository
public class MemberDao {
	
	public int insertMemeber(Connection conn, Member member) throws SQLException {
		int resultCnt=0;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO project.member " + 
					"(uid,upw,uname,uphoto) " + 
				   "VALUES " + 
				   	"(?,?,?,?);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphoto());

			resultCnt = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return resultCnt;
	}
	public int selectById(Connection conn, String id) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String sql = "select count(*) from project.member where uid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultCnt=rs.getInt(1);
			}
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		return resultCnt;
	}
	public int selectTotalCnt(Connection conn) throws SQLException {
		int resultCnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from project.member";
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				resultCnt= rs.getInt(1);
			}
		} finally {
			if(stmt!=null) {
				stmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		return resultCnt;
	}
	public List<Member> selectMemberList(Connection conn, int startRaw, int mESSAGE_COUNT_PER_PAGE) throws SQLException {
		List<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member mb;
		String sql = "select idx,uid,upw,uname,uphoto,regdate from project.member limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRaw);
			pstmt.setInt(2, mESSAGE_COUNT_PER_PAGE);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				mb = new Member(
							rs.getInt("idx"), 
							rs.getString("uid"), 
							rs.getString("upw"), 
							rs.getString("uname"), 
							rs.getString("uphoto"), 
							rs.getDate("regdate"));
				list.add(mb);
			}
		}finally {
			if (rs != null) {
				rs.close();				
			}
			if (pstmt != null) {
				pstmt.close();				
			}
		}
		return list;
	}
	public Member logincheck(Connection conn, String uid, String upw) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member =null;
		String sql = "select * from project.member where uid=? and upw=?";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						rs.getDate("regdate"));
			}
		}finally {
			if (rs != null) {
				rs.close();				
			}
			if (pstmt != null) {
				pstmt.close();				
			}
		}
		return member;
	}
	public int deleteMember(Connection conn, int idx) throws SQLException{
		int resultCnt=0;
		PreparedStatement pstmt=null;
		String sql = "delete from project.member where idx=?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			resultCnt = pstmt.executeUpdate();
		}finally {
			if (pstmt != null) {
				pstmt.close();				
			}
		}
		
		return resultCnt;
	}
	public int editMemeber(Connection conn, Member member) throws SQLException{
		int resultCnt=0;
		PreparedStatement pstmt=null;
		
		String sql = "update project.member set upw=?,uname=?,uphoto=? where uid=?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, member.getUpw());
			pstmt.setString(2, member.getUname());
			pstmt.setString(3, member.getUphoto());
			pstmt.setString(4, member.getUid());
			resultCnt = pstmt.executeUpdate();
		}finally {
			if (pstmt != null) {
				pstmt.close();				
			}
		}
		return resultCnt;
	}
}
