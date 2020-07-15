package member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import service.Service;

public class SearchServiceImpl implements Service{

	
	
	private void getViewPage2(HttpServletRequest request, HttpServletResponse response) {
	
		String uid = request.getParameter("uid");
		String a=null;
		System.out.println("gkgkgkt");
		try {
			Connection conn = ConnectionProvider.getConnection();
			ResultSet rs = null;
			String sql="select uid from project.member where uid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				out.print("Y");
			}else {
				out.print("N");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
	}

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		getViewPage2(request,response);
		return null;
	}

}
