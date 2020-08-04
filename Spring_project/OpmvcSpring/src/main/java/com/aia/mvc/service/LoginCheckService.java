package com.aia.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.jdbc.ConnectionProvider;
import com.aia.mvc.model.Member;

@Component("login")
public class LoginCheckService{
	
	@Autowired
	private MemberDao dao;
	
	public Member loginResult(Member mb, HttpServletRequest request) {
		String uid = mb.getUid();
		String upw = mb.getUpw();
		Connection conn = null;
		Member member = null;
		try {
			conn = ConnectionProvider.getConnection();
			member = dao.logincheck(conn,uid,upw);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return member;
	}

}
