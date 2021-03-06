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

public class LoginCheckServiceImpl implements Service {
	private MemberDao dao;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesson=request.getSession();
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			Member member = dao.logincheck(conn,uid,upw);
			if (member != null) {
				request.setAttribute("loginChk", 1);
				request.setAttribute("uid", uid);
				sesson.setAttribute("loginInfo", member);
			}else {
				request.setAttribute("loginChk", 0);
				
			}
			
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
		
		return "/WEB-INF/views/member/login.jsp";
	}

}
