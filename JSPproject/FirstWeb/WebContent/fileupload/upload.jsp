<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> ite = items.iterator();
		while (ite.hasNext()) {
			FileItem file = ite.next();
			//isFormField() : text value를 가지는 input 확인
			if(file.isFormField()){ //type==file 이외의 input
				//파라미터이름
				String paramName = file.getFieldName();
				//파라미터 값
				String paramVal = file.getString("UTF-8");
				System.out.println(paramName+"= "+paramVal);
			}else { //type==file
				//파라미터 이름
				String paramName = file.getFieldName();
				//파일이름
				String fileName = file.getName();
				//파일의 사이즈
				long file_size = file.getSize();
				//파일의 타입
				String contentType = file.getContentType();
				//임시 메모리에 저장여부
				boolean isInMemory = file.isInMemory();
				System.out.println("필드 이름 :  "+paramName);
				System.out.println("파일 이름 :  "+fileName);
				System.out.println("파일 크기 :  "+file_size);
				
				//String uri="/file";
				String uri = request.getSession().getServletContext().getInitParameter("uploadPath");
				String realPath = request.getSession().getServletContext().getRealPath(uri);
				
				System.out.println(realPath);
				
				//파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
				String newFileName = System.nanoTime() +"_"+ fileName;
				
				File saveFile = new File(realPath,newFileName);
				file.write(saveFile);
				System.out.println("저장완료");
				
			}
		}
	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>