package member.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberDelServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginInfo");
		String upw = member.getUpw();
		String chkpw = request.getParameter("upw");
		Connection conn =null;
		if(upw==chkpw) {
			
		}
		
		return "/WEB-INF/views/member/memberDelete.jsp";
	}

}
