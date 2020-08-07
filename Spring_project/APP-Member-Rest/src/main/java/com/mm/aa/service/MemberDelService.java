package com.mm.aa.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.aa.dao.MemberDao;
import com.mm.aa.model.Member;

@Service
public class MemberDelService {

	@Autowired
	private SqlSessionTemplate st;
	private MemberDao dao;
	
	public int deleteMember(int idx, HttpServletRequest req) {
		dao = st.getMapper(MemberDao.class);
		Member member = dao.selectByIdx(idx);
		if(member.getUphoto() !=null && member.getUphoto().length()>0) {
			File oFile = new File(req.getSession().getServletContext().getRealPath(member.getUphoto()));
			// oldFile 경로 이름으로 표시된 파일 또는 디렉터리가 있는 경우에만 true, 그렇지 않으면 false
			if (oFile.exists()) {
				// 파일 또는 디렉토리가 성공적으로 삭제된 경우에만 true, 그렇지 않으면 false
				if (oFile.delete()) {
					System.out.println("이전 파일은 삭제되엇습니다.");
				}
			}
		}
		return dao.deleteMember(idx);
	}
}
