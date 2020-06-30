package ver06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InfoDao {
	// INSERT INFO
	// basic info
	public int basicInsert(PhoneInfo info, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into phoneinfo_basic " 
					+ "values ("
					+ "PBB_idx_seq.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getpNumber());
			pstmt.setString(3, info.getEmail());
			pstmt.setString(4, info.getAddr());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	// univ info
	public int univInsert(PhoneUnivInfo info, Connection conn) throws SQLException {
		int resultCnt = 0;
		int result = basicInsert(info, conn);
		if (result > 0) {
			PreparedStatement pstmt = null;
			try {
				String sql = "insert into phoneinfo_univ " 
						+ "values ("
						+ "PBU_idx_seq.nextval,?,?,PBB_idx_seq.currval)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, info.getMajor());
				pstmt.setInt(2, info.getYear());
				resultCnt = pstmt.executeUpdate();
			} finally {
				if (pstmt != null) {
					pstmt.close();

				}
			}
		} else {
			System.out.println("입력에 실패 했습니다");
			return result;
		}
		return resultCnt;
	}

	// company info
	public int comInsert(PhoneCompanyInfo info, Connection conn) throws SQLException {
		int resultCnt = 0;
		int result = basicInsert(info, conn);
		if (result > 0) {
			PreparedStatement pstmt = null;
			try {
				String sql = "insert into phoneinfo_com " 
						+ "values ("
						+ "PBU_idx_seq.nextval,?,?,?,PBB_idx_seq.currval)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, info.getCompany());
				pstmt.setString(2, info.getDept());
				pstmt.setString(3, info.getJob());
				resultCnt = pstmt.executeUpdate();
			} finally {
				if (pstmt != null) {
					pstmt.close();
				}
			}
		} else {
			System.out.println("입력에 실패 했습니다");
			return result;
		}
		return resultCnt;
	}

	// cafe info
	public int cafeInsert(PhoneCafeInfo info, Connection conn) throws SQLException {
		int resultCnt = 0;
		int result = basicInsert(info, conn);
		if (result > 0) {
			PreparedStatement pstmt = null;
			try {
				String sql = "insert into phoneinfo_cafe " 
						+ "values ("
						+ "PBU_idx_seq.nextval,?,?,PBB_idx_seq.currval)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, info.getCafeName());
				pstmt.setString(2, info.getNickName());
				resultCnt = pstmt.executeUpdate();
			} finally {
				if (pstmt != null) {
					pstmt.close();
				}
			}
		} else {
			System.out.println("입력에 실패 했습니다");
			return result;
		}
		return resultCnt;
	}

	
	// SEARCH
	public List<PhoneInfo> searchInfo (String name, Connection conn) throws SQLException {
		List<PhoneInfo> list = new ArrayList<>();
		list = searchUniv(list, name, conn);
		list = searchCom(list, name, conn);
		list = searchCafe(list, name,conn);
		return list;
		
	}
	
	//대학 친구 검색
	public List<PhoneInfo> searchUniv(List<PhoneInfo> list,String name, Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from phoneinfo_basic b join phoneinfo_univ u "
					+ "on b.idx = u.ref and b.name like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PhoneInfo info = new PhoneUnivInfo(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("major"), 
						rs.getInt("year"));
				info.setIdx(rs.getInt("idx"));
				list.add(info);
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return list;
	}
	public List<PhoneInfo> searchCom(List<PhoneInfo> list,String name, Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from phoneinfo_basic b join phoneinfo_com c "
					+ "on b.idx = c.ref and b.name like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneInfo info = new PhoneCompanyInfo(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("company"), 
						rs.getString("dept"), 
						rs.getString("job"));
				info.setIdx(rs.getInt("idx"));
				list.add(info);
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return list;
	}
	
	public List<PhoneInfo> searchCafe(List<PhoneInfo> list,String name, Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from phoneinfo_basic b join phoneinfo_cafe f "
					+ "on b.idx = f.ref and b.name like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneInfo info = new PhoneCafeInfo(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("cafename"), 
						rs.getString("nickname"));
				info.setIdx(rs.getInt("idx"));
				list.add(info);
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return list;
	}
	
	public int deleteInfo(String name, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			String sql = "delete from phoneinfo_basic where name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			cnt = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		return cnt;
	}
	
	public int deleteInfo(int idx, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			String sql = "delete from phoneinfo_basic where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			cnt = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		return cnt;
	}
	
	public List<PhoneInfo> showUnivInfo(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		List<PhoneInfo>list = new ArrayList<>();
		try {
			stmt= conn.createStatement();
			String sql = "select * "
						+ "from phoneinfo_basic b join phoneinfo_univ u "
						+ "on b.idx = u.ref";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PhoneInfo info = new PhoneUnivInfo(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("major"), 
						rs.getInt("year"));
				info.setIdx(rs.getInt("idx"));
				list.add(info);
			} 
		
			
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
		
		return list;
	}
	public List<PhoneInfo> showComInfo(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		List<PhoneInfo>list = new ArrayList<>();
		try {
			stmt= conn.createStatement();
			String sql = "select * "
					+ "from phoneinfo_basic b join phoneinfo_com c "
					+ "on b.idx = c.ref";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PhoneInfo info = new PhoneCompanyInfo(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("company"), 
						rs.getString("dept"), 
						rs.getString("job"));
				info.setIdx(rs.getInt("idx"));
				list.add(info);
			} 
			
			
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
		
		return list;
	}
	public List<PhoneInfo> showCafeInfo(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		List<PhoneInfo>list = new ArrayList<>();
		try {
			stmt= conn.createStatement();
			String sql = "select * "
					+ "from phoneinfo_basic b join phoneinfo_cafe f "
					+ "on b.idx = f.ref";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PhoneInfo info = new PhoneCafeInfo(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("cafename"), 
						rs.getString("nickname"));
				info.setIdx(rs.getInt("idx"));
				list.add(info);
			} 
			
			
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
