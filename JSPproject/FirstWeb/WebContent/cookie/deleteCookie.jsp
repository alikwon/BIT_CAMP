<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키를 삭제합니다</h1>
	<%
		//Cookie cookie = new Cookie("uname","");
		//유효시간 : 초단위
		//cookie.setMaxAge(0);
		response.addCookie(CookieBox.createCookie("uname", "", "/aiaweb/cookie", 0));
	%>
	<a href="viewCookie.jsp">쿠키값 확인하기</a>
</body>
</html>