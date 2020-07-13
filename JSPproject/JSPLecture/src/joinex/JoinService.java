package joinex;

import java.sql.Connection;
import java.sql.SQLException;

public class JoinService {
	
	private JoinService() {}
	private static JoinService service = new JoinService();
	public static JoinService getInstance () {
		return service;
	}
	
	private MemberDao dao=null;
	
	public int joinMember(Member member) {
		int resultCnt=0;
		Connection conn= null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			resultCnt = dao.joinMember(conn, member);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultCnt;
	}
}
