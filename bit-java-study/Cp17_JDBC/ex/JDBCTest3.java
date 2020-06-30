package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest3 {

	public static void main(String[] args) {
		
		Connection conn = null;
		ResultSet rs = null;
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
			
			//3. sql로 데이터 처리
			//	데이터 조회 : Statement 
			Statement stmt =  conn.createStatement();
			System.out.println("회원이름 입력해주세요");
			Scanner kb = new Scanner(System.in);
			String searchName = kb.nextLine();
			String sql = "select empno,ename,job from emp "
//					+ "where ename='"+searchName+"'"
					;
			String sql1 = "select o.orderid, c.name, b.bookname "
						+ "from customer c, book b, orders o "
						+ "where c.custid = o.custid and o.bookid = b.bookid "
						+ "and c.name ='"+searchName+"'";
			
			//select 의 결과는 resultSet 이 받는다
			//excuteQuery (sql문) ==> resultSet
			rs = stmt.executeQuery(sql1);
			
			//resultSet : next() ==> 행의 존재 유무 확인
			System.out.println("────────┬───────┬────────");
			System.out.println("판매ID\t|회원이름\t|책 이름");
			System.out.println("────────┼───────┼────────");
//			System.out.println("────────┬───────┬────────");
//			System.out.println("사원번호\t|이름\t|직급");
//			System.out.println("────────┼───────┼────────");
			while(rs.next()) {
//				System.out.print(rs.getInt("deptno")+"\t");
//				System.out.print(rs.getString("dname")+"\t");
//				System.out.print(rs.getString("loc")+"\n");
				System.out.print(rs.getInt(1)+"\t|");
				System.out.print(rs.getString(2)+"\t|");
				System.out.print(rs.getString(3)+"\n");
			}
			
			//차례차례 닫아주기
			rs.close();
			stmt.close();
			
			//4. close
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
