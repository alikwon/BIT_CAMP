package emp_dept_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {
	//DAO = Data Access Object
	// 데이터 베이스 처리하는 클래스
	private static DeptDao dDao = new DeptDao();
	public static DeptDao getInstance() {
		return dDao;
	}
	//MVC => Model, View, Controller
	// model ==> Service , Dao
	// 데이터베이스 
	
	
	int deptEdit(Dept newDept, Connection conn) {
//		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//conn = ConnectionProvider.getConnection();
			
			String sql = "update dept " + "set dname =?, loc=? " + "where deptno =?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newDept.getDname());
			pstmt.setString(2, newDept.getLoc());
			pstmt.setInt(3, newDept.getDeptno());
			result = pstmt.executeUpdate();

			
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
			System.out.println("DB연결 종료");
		}
		return result;
	}
	int deptDelete(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "delete from dept " + "where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			result = pstmt.executeUpdate();
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
		return result;
	}

	// 리스트
	public List <Dept> deptList() {
		
		// Vo : value Object
		// DTO : Data Transfer Object
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//Dao 클래스 추가
		List<Dept> deptList = new ArrayList<>();
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "select * from dept";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dept dept = new Dept(
								rs.getInt("deptno"), 
								rs.getString("dname"), 
								rs.getString("loc"));
				deptList.add(dept);
//				System.out.print(rs.getInt("deptno") + "\t");
//				System.out.print(rs.getString(2) + "\t");
//				System.out.print(rs.getString("loc") + "\n");
			}
//			System.out.println("받아오기 완료 ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
//					System.out.println("rs종료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
//					System.out.println("pstmt종료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
//					System.out.println("conn종료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deptList;
	}

	// 검색
	public List <Dept> deptSearch(String dname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <Dept> list = new ArrayList<>();
		try {
			conn = ConnectionProvider.getConnection();
			String sql =null;
				sql = "select * from dept  "
						+ "where dname like '%'||?||'%' "
						+ "or  loc like '%'||?||'%'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dname);
				pstmt.setString(2, dname);
				rs= pstmt.executeQuery();
				while(rs.next()) {
					Dept d = new Dept (
								rs.getInt("deptno"),
								rs.getString("dname"),
								rs.getString("loc"));
					list.add(d);
				}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public int deptSearchCount(String searchName, Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int rowCnt = 0;
		
		try {
			
			String sql = "select count(*) from dept where dname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				rowCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return rowCnt;
	}
	
	public Dept deptSearchName(String searchName, Connection conn) {
		
		Dept dept = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from dept where dname =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dept = new Dept (rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

}
