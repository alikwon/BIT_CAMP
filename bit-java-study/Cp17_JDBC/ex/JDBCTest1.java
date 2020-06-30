package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		//1. DB 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			
			//URL
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
			//아이디
			String user = "scott";	
			//비번
			String pw = "tiger";
			
			//2. DB에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다");
			
			//트랜젝션 설정
			conn.setAutoCommit(false);
			
			//commit : 처리완료
			conn.commit(); // 트렌젝션
			//4. close
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			//rollback : 트랜젝션 처리
			try {
				conn.rollback(); 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
