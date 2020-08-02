package com.aia.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.jdbc.ConnectionProvider;

@Component("idCheck")
public class IdCheckServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String result = "N";
		
		String id = request.getParameter("uid");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			int resultCnt = dao.selectById(conn, id);
			
			if(resultCnt<1) {
				result = "Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("idcheck", result);
		
		return "member/idCheck";
	}

}