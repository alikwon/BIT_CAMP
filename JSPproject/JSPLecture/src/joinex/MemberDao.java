package joinex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
	
	private MemberDao() {}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public int joinMember(Connection conn, Member member) throws SQLException {
		int resultCnt=0;
		PreparedStatement pstmt=null;
		
		String sql = "insert into member values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getGender());
			resultCnt = pstmt.executeUpdate();
		}finally {
			if(pstmt!=null) pstmt.close();
		}
		return resultCnt;
	}

	public int searchMember(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
}
