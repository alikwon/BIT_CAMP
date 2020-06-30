package ver06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		
		conn = DriverManager.getConnection(url, user, pw);
		System.out.println("데이터베이스 접속 완료");
		return conn;
	}
}
