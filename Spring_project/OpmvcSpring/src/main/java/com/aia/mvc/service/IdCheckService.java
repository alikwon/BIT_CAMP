package com.aia.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.jdbc.ConnectionProvider;

@Component("idCheck")
public class IdCheckService {

	@Autowired
	private MemberDao dao;
	
	public String checkId(String uid) {
		
		String result = "N";
		
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			int resultCnt = dao.selectById(conn, uid);
			
			if(resultCnt<1) {
				result = "Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

}