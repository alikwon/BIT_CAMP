package member.service;

import java.io.File;
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

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberRegServiceImpl implements Service {

	MemberDao dao;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// 파일 업로드- 사진
		// 사용자 데이터 받기 - uid,upw,uname,uphoto
		int resultCnt = 0;

		// DB에 입력할 데이터 변수
		String uid = null;
		String upw = null;
		String uname = null;
		String uphoto = null;
		Connection conn = null;
		try {
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				// 팩토리 만들기 --> 저장공간 만들기
				DiskFileItemFactory factory = new DiskFileItemFactory();

				ServletFileUpload upload = new ServletFileUpload(factory);
				// 잘라주는 역할
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> ite = items.iterator();
				while (ite.hasNext()) {
					FileItem file = ite.next();
					// isFormField() : text value를 가지는 input 확인
					if (file.isFormField()) { // type==file 이외의 input
						// 파라미터이름
						String paramName = file.getFieldName();
						// 파라미터 값
						String paramVal = file.getString("UTF-8");
						// System.out.println(paramName + "= " + paramVal);

						if (paramName.equals("uid")) {
							uid = paramVal;
						} else if (paramName.equals("upw")) {
							upw = paramVal;
						} else if (paramName.equals("uname")) {
							uname = paramVal;
						}
					} else { // type==file
						String uri="/upload/users";
//						String uri = request.getSession()
//											.getServletContext()
//											.getInitParameter("uploadPath");
						String realPath = request.getSession()
												 .getServletContext()
												 .getRealPath(uri);

//						System.out.println(realPath);

						// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
						String newFileName = System.nanoTime() + "_" + file.getName();

						File saveFile = new File(realPath, newFileName);
						file.write(saveFile);
						System.out.println("저장완료");

//						saveFile.delete();

						uphoto = uri + "/" + newFileName; // 웹경로

					}
				}

				// 공백문자일 때 null처리

				// 데이터 베이스 저장
				Member member = new Member();
				member.setUid(uid);
				member.setUpw(upw);
				member.setUname(uname);
				member.setUphoto(uphoto);
				
				
				conn = ConnectionProvider.getConnection();//예외발생가능
				dao = MemberDao.getInstance();
				
				resultCnt = dao.insertMemeber(conn, member);//0이 나올가능성
				
				request.setAttribute("member",member);
				request.setAttribute("result",resultCnt);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "/WEB-INF/views/member/reg.jsp";
	}
	
}
