package com.aia.mvc.service;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.Member;

@Component
public class MemberDelService {

//	@Autowired
//	private JdbcTemplateMemberDao dao;

	private MemberDaoInterface dao;

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public int delService(Member member, String chkpw, HttpSession session) {
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);
		int idx = member.getIdx();
		String upw = member.getUpw();
		String uphoto = null;
		System.out.println("upw : " + upw);
		System.out.println("chkpw : " + chkpw);
		int resultCnt = 0;

		if (upw.equals(chkpw)) {
			uphoto = member.getUphoto();
			resultCnt = dao.deleteMember(idx);
			System.out.println("resultCnt : "+resultCnt);
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
		} else {
			return resultCnt;
		}

		return resultCnt;
	}

}
