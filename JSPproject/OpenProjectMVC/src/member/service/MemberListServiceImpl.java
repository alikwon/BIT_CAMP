package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberList;
import service.Service;

public class MemberListServiceImpl implements Service {
	private MemberDao dao;
	private final int MESSAGE_COUNT_PER_PAGE = 3;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// startRaw = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
		Connection conn = null;
		MemberList view = null;
		int pageNum =1;
		if(request.getParameter("page")!=null) {
			pageNum = Integer.parseInt(request.getParameter("page"));
		}
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			List<Member> mbList=new ArrayList<Member>();
			
			//가입한 전체 회원 수
			int mbTotalCnt = dao.selectTotalCnt(conn);
			int startRaw = 0;
			
			if(mbTotalCnt >0) {
				startRaw = (pageNum -1)*MESSAGE_COUNT_PER_PAGE;
				mbList = dao.selectMemberList(conn,startRaw,MESSAGE_COUNT_PER_PAGE);
			}else {
				pageNum = 0;
				mbList = Collections.emptyList();
			}
			view = new MemberList(
							mbList, 
							mbTotalCnt, 
							pageNum,
							mbTotalCnt,
							MESSAGE_COUNT_PER_PAGE,
							startRaw);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}finally {
			if(conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("listView", view);
		return "/WEB-INF/views/member/memberList.jsp";
	}

}
