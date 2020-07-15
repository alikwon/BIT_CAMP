package member.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import service.Service;

public class MemberDelServiceImpl implements Service {

	private MemberDao dao;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		String uid = request.getParameter("delid");
		
		
		return "/WEB-INF/views/member/memberList.jsp";
	}

}
