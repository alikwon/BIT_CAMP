package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Report;

public class ReportDao {
	private ReportDao() {}
	private static ReportDao rd = new ReportDao();
	public static ReportDao getInstance() {
		return rd;
	}
	
	public int insertReport (Connection conn, Report report) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into report " + 
					"values (report_seq.nextval , ? , ? , ? ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, report.getSname());
			pstmt.setString(2, report.getSno());
			pstmt.setString(3, report.getReport());
			
			resultCnt = pstmt.executeUpdate();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return resultCnt;
	}
}
