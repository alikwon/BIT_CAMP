package com.aia.mvc.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.jdbc.ConnectionProvider;
import com.aia.mvc.model.Member;

@Component
public class MemberDelService {

	@Autowired
	private MemberDao dao;

	public int delService(Member member, String chkpw, HttpSession session) {
		int idx = member.getIdx();
		String upw = member.getUpw();
		String uphoto = null;
		System.out.println("upw : " + upw);
		System.out.println("chkpw : " + chkpw);
		Connection conn = null;
		int resultCnt = 0;

		try {
			if (upw.equals(chkpw)) {
				uphoto = member.getUphoto();
				conn = ConnectionProvider.getConnection();
				resultCnt = dao.deleteMember(conn, idx);

				if (uphoto != null) {
					File oFile = new File(session.getServletContext().getRealPath(uphoto));
					// oldFile 경로 이름으로 표시된 파일 또는 디렉터리가 있는 경우에만 true, 그렇지 않으면 false
					if (oFile.exists()) {
						// 파일 또는 디렉토리가 성공적으로 삭제된 경우에만 true, 그렇지 않으면 false
						if (oFile.delete()) {
							System.out.println("이전 파일은 삭제되엇습니다.");
						}
					}

				}
			}else {
				return resultCnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return resultCnt;
	}

}
