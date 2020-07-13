package joinex;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginService {
	
	private LoginService() {}
	private LoginService ls = new LoginService();
	public LoginService getInstance() {
		return ls;
	}
	
	private MemberDao dao;
	
	public int searchMember() {
		int resultCnt=0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			resultCnt = dao.searchMember(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultCnt;
	}
}
