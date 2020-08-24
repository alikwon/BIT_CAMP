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
import com.aia.mm.model.MemberEditInfo;


@Service
public class MemberEditService {

	@Autowired
	private SqlSessionTemplate st;
	private MemberDao dao;

	public int editMember(HttpServletRequest request, MemberEditInfo info) {
		dao = st.getMapper(MemberDao.class);
		int resultCnt = 0;
		String uphoto = null;// 사진수정을 하지 않으면 null
		MultipartFile file = null;
		try {

			// 유저가 사진을 수정했을 경우
			if (info.getUphoto() != null&&info.getUphoto().getSize() > 0 ) {
				file = info.getUphoto();
				String uri = "/upload";
				String realPath = request.getSession().getServletContext().getRealPath(uri);

				// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장완료" + newFileName);

				uphoto = uri + "/" + newFileName; // 웹경로

				// 기존의 사진은 지워줌
				File oFile = new File(request.getSession().getServletContext().getRealPath(info.getOldFile()));
				// oldFile 경로 이름으로 표시된 파일 또는 디렉터리가 있는 경우에만 true, 그렇지 않으면 false
				if (oFile.exists()) {
					// 파일 또는 디렉토리가 성공적으로 삭제된 경우에만 true, 그렇지 않으면 false
					if (oFile.delete()) {
						System.out.println("이전 파일은 삭제되엇습니다.");
					}
				}

			} else {
				// 사진 수정을 안했을 경우 옛날사진
				uphoto = info.getOldFile();
			}

			// 데이터 베이스 저장
			Member member = info.setMember();
			member.setUphoto(uphoto);
			member.setIdx(info.getIdx());
			System.out.println(member);
			resultCnt = dao.editMember(member);// 0이 나올가능성
			System.out.println("수정?"+resultCnt);
		} // 예외발생가능
		catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultCnt;
	}
}
