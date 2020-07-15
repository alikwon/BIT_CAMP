package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.Member;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance () {
		return dao;
	}
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
}
