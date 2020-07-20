package member.service;

import java.io.File;
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
				
				File oFile = new File(request.getSession().getServletContext().getRealPath(member.getUphoto()));
				// oldFile 경로 이름으로 표시된 파일 또는 디렉터리가 있는 경우에만 true, 그렇지 않으면 false
				if(oFile.exists()) {
					//파일 또는 디렉토리가 성공적으로 삭제된 경우에만 true, 그렇지 않으면 false
					if(oFile.delete()) {
						System.out.println("이전 파일은 삭제되엇습니다.");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("resultDel", resultCnt);
		return "/WEB-INF/views/member/memberDelete.jsp";
	}

}
