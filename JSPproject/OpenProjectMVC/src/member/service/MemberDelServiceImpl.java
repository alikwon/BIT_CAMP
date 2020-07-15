package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberDelServiceImpl implements Service {
	MemberDao dao;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginInfo");
		String uid = member.getUid();
		String upw = member.getUpw();
		String chkpw = request.getParameter("upw");
		System.out.println("uid : "+uid);
		System.out.println("upw : "+upw);
		System.out.println("chkpw : "+chkpw);
		Connection conn =null;
		int resultCnt=0;
		
		if(upw.equals(chkpw)) {
			try {
				
				conn= ConnectionProvider.getConnection();
				dao= MemberDao.getInstance();
				resultCnt = dao.deleteMember(conn,uid);
				session.invalidate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("resultDel", resultCnt);
		return "/WEB-INF/views/member/memberDelete.jsp";
	}

}
