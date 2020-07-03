<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("id");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("check");
	
	String cookieName = "";
	if(uid!=null && chk!=null){
		response.addCookie(CookieBox.createCookie(uid, pw, "/aiaweb/member", -1));
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