package emp_dept_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptManager {
	Scanner sc = new Scanner(System.in);
	DeptDao dao = DeptDao.getInstance();

	void deptInput() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터 베이스에 접속함");

			System.out.println("부서 번호 입력 >>");
			int deptno = Integer.parseInt(sc.nextLine().trim());

			System.out.println("부서이름 입력 >>");
			String dname = sc.nextLine();

			System.out.println("부서의 지역 입력>>");
			String loc = sc.nextLine();

			String sql = "insert into dept " + "values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
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

	// 수정(부서이름,위치)
	void deptEdit() {
		
		Connection conn = null;
		// conn을 매개변수로 주면서 트랜잭션 처리
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);// 기본값 true = 오토커밋
			// 1. 수정하고자하는 데이터 유무 확인
			System.out.println("수정할 부서 이름>>");
			String searchName = sc.nextLine();
		
			int rowCnt = dao.deptSearchCount(searchName, conn);
			System.out.println(rowCnt + "개 확인됨");
			
			if (rowCnt > 0) {
				Dept dept = dao.deptSearchName(searchName, conn);
				if (dept == null) {
					System.out.println("해당부서가 존재하지않습니다");
					return;
				}
				System.out.println("수정할 부서의 부서번호 " + dept.getDeptno());
				System.out.println("부서 이름(" + dept.getDname() + ") 수정>>");
				String dname = sc.nextLine().trim();
				System.out.println("부서 지역 (" + dept.getLoc() + ")수정>>");
				String loc = sc.nextLine().trim();
				
				Dept newDept = new Dept(dept.getDeptno(), dname, loc);
				
				int resultCnt = dao.deptEdit(newDept, conn);
				
				if (resultCnt > 0) {
					System.out.println("정상적으로 수정 완료 ");
				}
				
			} else {
				System.out.println("해당부서가 존재하지않습니다");
			}
			
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
			e.printStackTrace();
		} 
		
	}

	// 삭제(부서번호)
	public void deptDelete() {
		deptList();
		System.out.println("삭제 부서 번호 입력");
		int deptDelNum = Integer.parseInt(sc.nextLine().trim());
		int result = dao.deptDelete(deptDelNum);
		if (result <= 0) {
			System.out.println("해당 부서가 존재하지 않습니다");
			System.out.println("삭제실패. 확인후 다시 시도하세요");
			return;
		} else {
			System.out.println(result + "개의 부서가 삭제됐습니다.");
		}
	}

	// 리스트
	public void deptList() {
		List<Dept> deptList = dao.deptList();
		if (deptList != null && !deptList.isEmpty()) {
			for (int i = 0; i < deptList.size(); i++) {
				System.out.printf("%5d", deptList.get(i).getDeptno());
				System.out.print("\t");
				System.out.printf("%12s", deptList.get(i).getDname() + "\t");
				System.out.printf("%12s", deptList.get(i).getLoc() + "\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다");
		}
	}

	// 검색
	void deptSearch() {
		System.out.println("검색입력");
		String searchName = sc.nextLine();
		List<Dept> list = dao.deptSearch(searchName);

		System.out.println("검색결과");
		System.out.println("==================================");
		for (Dept d : list) {
			System.out.printf("%5s", d.getDeptno() + "\t");
			System.out.printf("%12s", d.getDname() + "\t");
			System.out.printf("%12s", d.getLoc() + "\n");
		}
	}

}
