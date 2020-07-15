package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao.ReportDao;
import jdbc.ConnectionProvider;
import model.Report;

public class ReportRegService {
	private ReportRegService() {
	}

	private static ReportRegService rrs = new ReportRegService();

	public static ReportRegService getInstance() {
		return rrs;
	}

	ReportDao dao;

	public int regReport(HttpServletRequest request) {
		int resultCnt = 0;
		
		String sname = "";
		String sno ="";
		String filePath ="";
		Connection conn = null;
		try {

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
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
						System.out.println(paramName + "= " + paramVal);
						
						if(paramName.equals("uname")) {
							sname = paramVal;
						}else if (paramName.equals("sno")) {
							sno = paramVal;
						}
					} else { // type==file
						// 파라미터 이름
						String paramName = file.getFieldName();
						// 파일이름
						String fileName = file.getName();
						System.out.println(fileName);
						// 파일의 사이즈
						long file_size = file.getSize();
						// 파일의 타입
						String contentType = file.getContentType();
						// 임시 메모리에 저장여부
						boolean isInMemory = file.isInMemory();
						System.out.println("필드 이름 :  " + paramName);
						System.out.println("파일 이름 :  " + fileName);
						System.out.println("파일 크기 :  " + file_size);

						// String uri="/file";
						String uri = request.getSession().getServletContext().getInitParameter("uploadPath");
						String realPath = request.getSession().getServletContext().getRealPath(uri);

						System.out.println(realPath);

						// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
						String newFileName = System.nanoTime() + "_" + fileName;

						File saveFile = new File(realPath, newFileName);
						file.write(saveFile);
						System.out.println("저장완료");
						
//						saveFile.delete();
						
						filePath = uri+"/"+newFileName; //웹경로

					}
				}
				
				//공백문자일 때 null처리
				
				//데이터 베이스 저장
				Report report = new Report();
				report.setSname(sname);
				report.setSno(sno);
				report.setReport(filePath);
				
				conn = ConnectionProvider.getConnection();
				dao = ReportDao.getInstance();
				resultCnt = dao.insertReport(conn, report);
				
				//응답을 report에 저장
				request.setAttribute("report", report);
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
		}  finally {

		}
		return resultCnt;
	}
}
