package emp_dept_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpManager {
	Scanner sc = new Scanner(System.in);
	
	void empInput() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			// 사원번호 입력
			System.out.println("사원 번호 입력>>");
			int empno = Integer.parseInt(sc.nextLine().trim());

			// 사원이름 입력
			System.out.println("사원 이름 입력>>");
			String ename = sc.nextLine().trim();

			// 사원직급 입력
			System.out.println("사원 직급 입력>>");
			String job = sc.nextLine().trim();

			// 상사 입력
			System.out.println("상사의 사원번호  입력>>");
			int mgr = Integer.parseInt(sc.nextLine().trim());

			// 입사일 입력
			System.out.println("입사일  입력(YY/MM/DD)>>");
			String hiredate = sc.nextLine().trim();
			
//			String hiredate = null;
//			if (a.isEmpty())
//				hiredate = "sysdate";
//			else
//				hiredate = a;

			// 월급 입력
			System.out.println("월급  입력>>");
			int sal = Integer.parseInt(sc.nextLine().trim());

			// 커미션 입력
			System.out.println("커미션  입력>>");
			int comm = Integer.parseInt(sc.nextLine().trim());

			// 부서 번호 입력
			System.out.println("부서 번호 입력");
			int deptno = Integer.parseInt(sc.nextLine().trim());

			String sql = "insert into emp " 
						+ "values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);
			// 실행 횟수 반환
			int result = pstmt.executeUpdate();
			if (result == 0) {
				System.out.println("입력에 실패했습니다 확인후 다시 해주세요");
				return;
			}
			System.out.println(result + "개의 행이 적용됨");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("DB연결 종료");
		}
	}
	void empEdit() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("수정할 사원의 사원 번호 입력>>");
			int empno = Integer.parseInt(sc.nextLine().trim());
			System.out.println("이름 수정 >>");
			String ename = sc.nextLine().trim();
			System.out.println("부서 수정 >>");
			int deptno = Integer.parseInt(sc.nextLine().trim());
			System.out.println("급여 수정 >> ");
			int sal = Integer.parseInt(sc.nextLine().trim());
			
			String sql = "update emp "
						+ "set ename = ?, deptno =?, sal=? "
						+ "where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setInt(2, deptno);
			pstmt.setInt(3, sal);
			pstmt.setInt(4, empno);
			int result = pstmt.executeUpdate();
			
			if (result < 0) {
				System.out.println("입력에 실패했습니다 확인후 다시 해주세요");
				return;
			}
			System.out.println(result + "개의 행이 적용됨");
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("DB연결 종료");
		}

	}

	void empSearch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			
			System.out.println("검색할 이름입력");
			String name = sc.nextLine().trim();
			
			//Mysql
			// select * from emp where ename like '%'||?||'%'
			//psmt.setString(1,"%"+name+"%");
			String sql = "select * from emp where ename =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("DB연결 종료");
		}
	}
	
	void empList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("DB연결 종료");
		}
	}
	
	void empDelete() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			
			System.out.println("삭제할 사원의 사원 번호 입력>>");
			int empno = Integer.parseInt(sc.nextLine().trim());
			
			String sql = "delete from emp "
						+ "where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				System.out.println("처리에 실패했습니다 확인후 다시 해주세요");
				return;
			}
			System.out.println(result + "개의 행이 적용됨");
			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("DB연결 종료");
		}
	}
}
