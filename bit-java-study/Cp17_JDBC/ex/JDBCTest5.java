package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest5 {
	
	public static void main(String[] args) {
		//JDBC 사용객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//0. 드라이버 LIB 추가
			//1. 데이터 베이스 드라이버 로드
			//	 class.forName(드라이버 클래스 전체이름)
			//	 Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 데이터베이스 연결
			// jdbc:oracle:thin:@주소:포트:DB이름
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw ="tiger";
			
			//	Connect 객체 생성
			conn = DriverManager.getConnection(url, user, pw);
						
			//3. SQL처리
			//	Statement or PreparedStatement 필요
			//	pstmt = conn.prepareStatement(sql);
//			String sql ="select * from dept where deptno=??";
//			pstmt = conn.prepareStatement(sql);
//			//	변수 데이터 설정
//			//	setBlob : 2기가 txt파일
//			pstmt.setInt(1, 10);
//			rs = pstmt.executeQuery(); // ResultSet 반환
//			//	ResultSet => 결과 참조
//			System.out.println("부서목록");
//			System.out.println("================================");
//			while(rs.next()) {
//				System.out.print(rs.getInt("deptno")+"\t");
//				System.out.print(rs.getString("dname")+"\t");
//				System.out.print(rs.getString("loc")+"\n");
//			}
//			System.out.println("================================");
//			
			String sql = "insert into dept(deptno,dname,loc)"
						+ "values (?,?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, 70);
			pstmt.setString(2, "마케팅");
			pstmt.setString(3, "서울");
			
			int resultCnt = pstmt.executeUpdate();
			if (resultCnt > 0) {
				System.out.println("정상적으로 "+resultCnt+"개의 행이 입력됐졍");
			}else {
				System.out.println("입력되지않았엉. 확인후 다시하세염");
			}
			
			//4. 데이터베이스 연결 종료
//			rs.close();
//			System.out.println("rs 종료");
			pstmt.close();
			System.out.println("pstmt 종료");
			conn.close();
			System.out.println("conn 종료");
			System.out.println("DB연결 종료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//			if(pstmt !=null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}				
//			}
//			
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}				
//			}
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
					System.out.println("rs 종료2");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(pstmt !=null) {
				try {
					pstmt.close();
					System.out.println("pstmt 종료2");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
			
			if(conn != null) {
				try {
					conn.close();
					System.out.println("conn 종료2");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
			System.out.println("DB연결 종료2");
		}//try-catch
	}
}
