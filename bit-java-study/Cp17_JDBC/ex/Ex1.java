package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Jdbc 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			// 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결함");

////1.EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
			Scanner sc = new Scanner(System.in);
//			// 사원번호 입력
//			System.out.println("사원 번호 입력");
//			int empno = Integer.parseInt(sc.nextLine().trim());
//			
//			// 사원이름 입력
//			System.out.println("사원 이름 입력");
//			String ename = sc.nextLine().trim();
//			
//			// 사원직급 입력
//			System.out.println("사원 직급 입력");
//			String job = sc.nextLine().trim();
//			
//			// 상사 입력
//			System.out.println("상사의 사원번호  입력");
//			int mgr = Integer.parseInt(sc.nextLine().trim());
//			
//			// 입사일 입력
//			System.out.println("입사일  입력(입력안할시 오늘날짜)");
//			String a = sc.nextLine().trim();
//			String hiredate=null;
//			if (a.isEmpty())
//				hiredate = "sysdate";
//			else 
//				hiredate = "'"+a+"'";
//			
//			// 월급 입력
//			System.out.println("월급  입력");
//			String sal = sc.nextLine().trim();
//			
//			// 커미션 입력
//			System.out.println("커미션  입력");
//			String comm = sc.nextLine().trim();
//			
//			// 부서 번호 입력
//			System.out.println("부서 번호 입력");
//			String deptno = sc.nextLine().trim();
//			
//			String sql = 
//					"insert into emp01 values("
//					+ empno+","
//					+ "'"+ename+"',"
//					+ "'"+job+"',"
//					+ mgr+","
//					+ "to_date("+hiredate+",'YY/MM/DD'),"
//					+ "to_number('"+sal+"'),"
//					+ "to_number('"+comm+"'),"
//					+ "to_number('"+deptno+"'))";
//			stmt = conn.createStatement();
//			//실행 횟수 반환
//			int result = stmt.executeUpdate(sql);
//			System.out.println(result + "개의 행이 적용됨");
//							
////2.EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
//			String sql = "select * from emp01";
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery(sql);
//			
//			while (rs.next()) {
//				System.out.print(rs.getInt("empno") + "\t");
//				System.out.print(rs.getString("ename") + "\t");
//				System.out.print(rs.getString("job") + "\t");
//				System.out.print(rs.getInt("mgr") + "\t");
//				System.out.print(rs.getDate("hiredate") + "\t");
//				System.out.print(rs.getInt("sal") + "\t");
//				System.out.print(rs.getInt("comm") + "\t");
//				System.out.print(rs.getInt("deptno") + "\n");
//			}
//3.EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
//			String sql = "update emp01 set sal=3000 where ename = 'SCOTT'";
//			stmt = conn.createStatement();
//			int result = stmt.executeUpdate(sql);
//			System.out.println(result+"개 행이 적용됨");
//4.EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
//			System.out.println("이름입력");
//			String name = sc.nextLine().trim();
//			String sql = "select * from emp where ename = '"+name+"'";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				System.out.print(rs.getInt("empno") + "\t");
//				System.out.print(rs.getString("ename") + "\t");
//				System.out.print(rs.getString("job") + "\t");
//				System.out.print(rs.getInt("mgr") + "\t");
//				System.out.print(rs.getDate("hiredate") + "\t");
//				System.out.print(rs.getInt("sal") + "\t");
//				System.out.print(rs.getInt("comm") + "\t");
//				System.out.print(rs.getInt("deptno") + "\n");
//			}
//5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
			String sql = "select * from emp01 natural join dept";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\n");
			}


			// 4. close
			rs.close();
			pstmt.close();
//			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		}
	}
}
