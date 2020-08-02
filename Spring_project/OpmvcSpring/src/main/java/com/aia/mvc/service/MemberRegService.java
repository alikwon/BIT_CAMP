package com.aia.mvc.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.jdbc.ConnectionProvider;
import com.aia.mvc.model.Member;
import com.aia.mvc.model.MemberRegInfo;

@org.springframework.stereotype.Service
public class MemberRegService {

	MemberDao dao;

	public HttpServletRequest regMember(MemberRegInfo info, HttpServletRequest request) {

		// dao결과값
		int resultCnt = 0;

		// 유저가 등록한 사진파일
		MultipartFile file = info.getUphoto();

		// DB에 저장할 사진경로
		String uphoto = null;

		Connection conn = null;

		try {
			String uri = "/upload/users";
//						String uri = request.getSession()
//											.getServletContext()
//											.getInitParameter("uploadPath");
			String realPath = request.getSession().getServletContext().getRealPath(uri);

			// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
			String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

			File saveFile = new File(realPath, newFileName);
			file.transferTo(saveFile);
			System.out.println("저장완료"+newFileName);

			uphoto = uri + "/" + newFileName; // 웹경로

			// 공백문자일 때 null처리

			// 데이터 베이스 저장
			Member member = new Member();
			member.setUid(info.getUid());
			member.setUpw(info.getUpw());
			member.setUname(info.getUname());
			member.setUphoto(uphoto);

			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();

			resultCnt = dao.insertMemeber(conn, member);// 0이 나올가능성

			request.setAttribute("member", member);
			request.setAttribute("result", resultCnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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

		return request;
	}

}
