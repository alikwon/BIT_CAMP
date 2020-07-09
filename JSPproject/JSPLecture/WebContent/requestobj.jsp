<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("서버: "+ request.getServerName()+"<br>");
		out.println("서버: "+ request.getServerPort()+"<br>");
		out.println("서버: "+ request.getMethod()+"<br>");
		out.println("서버: "+ request.getRequestURL()+"<br>");
		out.println("서버: "+ request.getRequestURI());
	%>
</body>
</html>