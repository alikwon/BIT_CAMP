package com.aia.mm.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.mm.dao.MemberDao;
import com.aia.mm.model.Member;
import com.aia.mm.model.MemberRegInfo;


@Service
public class MemberRegService {

	@Autowired
	private SqlSessionTemplate st;
	private MemberDao dao;

	public int regMember(MemberRegInfo info, HttpServletRequest req) {
		dao = st.getMapper(MemberDao.class);
		int result = 0;
		String uphoto = null;
		MultipartFile file = info.getUphoto();
		try {
			if (file != null && file.getSize() > 0 && !file.isEmpty()) {
				String uri = "/upload";
				String realPath = req.getSession().getServletContext().getRealPath(uri);

				// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장완료" + newFileName);

				uphoto = uri + "/" + newFileName; // 웹경로
			} else {
				System.out.println("사진없음");
			}

			// 데이터 베이스 저장
			Member member = info.setMember();
			member.setUphoto(uphoto);

			System.out.println("전idx : " + member.getIdx());

			result = dao.insertMember(member);// 0이 나올가능성
			System.out.println("후idx : " + member.getIdx());
			req.setAttribute("member", member);
			req.setAttribute("result", result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
