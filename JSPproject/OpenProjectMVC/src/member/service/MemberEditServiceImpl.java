package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberEditServiceImpl implements Service {

	private MemberDao dao;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 사진 수정이 발생했을 때 기존 사진을 삭제하기위해 로그인한 객체를 가져옴
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		int resultCnt = 0;
		int idx = -1;
		String upw = null;
		String uname = null;
		String oldFile = loginInfo.getUphoto();
		String uphoto = oldFile; //사진수정을 하지 않으면 옛날 사진
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
					if (file.isFormField()) {
						// 파라미터이름
						String paramName = file.getFieldName();
						// 파라미터 값
						String paramVal = file.getString("UTF-8");
						// System.out.println(paramName + "= " + paramVal);

						if (paramName.equals("upw")) {
							upw = paramVal;
						} else if (paramName.equals("uname")) {
							uname = paramVal;
						} 
					} else { // type==file
						// 사진파일이 없는채로 들어오면 안됨 --> 없으면 oldFile로 고정
						if (file.getFieldName().equals("uphoto") && file.getSize() > 0) {
							String uri = "/upload/users";
							String realPath = request.getSession().getServletContext().getRealPath(uri);

							// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
							String newFileName = System.nanoTime() + "_" + file.getName();

							File saveFile = new File(realPath, newFileName);
							file.write(saveFile);
							System.out.println("저장완료");

							// saveFile.delete();

							uphoto = uri + "/" + newFileName; // 웹경로
						}
					}
				}
				
				//사용자가 사진을 수정했을경우 -->uphoto!=null
				if(uphoto!=null) {
					File oFile = new File(request.getSession().getServletContext().getRealPath(oldFile));
					// oldFile 경로 이름으로 표시된 파일 또는 디렉터리가 있는 경우에만 true, 그렇지 않으면 false
					if(oFile.exists()) {
						//파일 또는 디렉토리가 성공적으로 삭제된 경우에만 true, 그렇지 않으면 false
						if(oFile.delete()) {
							System.out.println("이전 파일은 삭제되엇습니다.");
						}
					}
				}

				// 데이터 베이스 저장
				Member member = new Member();
				member.setIdx(loginInfo.getIdx());
				member.setUid(loginInfo.getUid());
				member.setUpw(upw);
				member.setUname(uname);
				member.setUphoto(uphoto);
				member.setRegdate(loginInfo.getRegdate());

				conn = ConnectionProvider.getConnection();// 예외발생가능
				dao = MemberDao.getInstance();

				resultCnt = dao.editMemeber(conn, member);// 0이 나올가능성
				
				if(resultCnt>0) {
					session.setAttribute("loginInfo", member);
				}
				request.setAttribute("result", resultCnt);
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "/WEB-INF/views/member/memberEdit.jsp";
	}

}
