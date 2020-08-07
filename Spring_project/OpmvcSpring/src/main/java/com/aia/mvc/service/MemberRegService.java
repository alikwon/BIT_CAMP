package com.aia.mvc.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.aia.mvc.dao.MemberDaoInterface;
import com.aia.mvc.model.Member;
import com.aia.mvc.model.MemberRegInfo;

@org.springframework.stereotype.Service
public class MemberRegService {

//	@Autowired
//	private JdbcTemplateMemberDao dao;
	
//	@Autowired
//	private MybatisMemberDao dao;

	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate st;
	
	public HttpServletRequest regMember(MemberRegInfo info, HttpServletRequest request) {
		dao = st.getMapper(MemberDaoInterface.class);
		// dao결과값
		int resultCnt = 0;

		// 유저가 등록한 사진파일
		MultipartFile file = null;

		// DB에 저장할 사진경로
		String uphoto = null;

		try {
			
			file = info.getUphoto();
			if(file.getSize()>0 && file !=null&& !file.isEmpty()) {
				String uri = 
						request.getSession().getServletContext().getInitParameter("uploadPath");
				String realPath = request.getSession().getServletContext().getRealPath(uri);
				
				// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();
				
				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장완료"+newFileName);
				
				uphoto = uri + "/" + newFileName; // 웹경로
			} else {
				System.out.println("사진없음");
			}

			// 데이터 베이스 저장
			Member member = info.setMember();
			member.setUphoto(uphoto);

			
			System.out.println("전idx : "+member.getIdx());
			
			resultCnt = dao.insertMember(member);// 0이 나올가능성
			System.out.println("후idx : "+member.getIdx());
			request.setAttribute("member", member);
			request.setAttribute("result", resultCnt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return request;
	}

}
