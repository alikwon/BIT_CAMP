<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox cookiebox = new CookieBox(request);
%>
<%--
	Cookie[] cookies = request.getCookies();
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cookie</title>
</head>
<body>
	<h1>쿠키 정보</h1>
	<!-- 쿠키박스 -->
	<div>
		uid=
		<%= cookiebox.getCookie("uid").getValue()%>
		<br>
		uname=
		<%= cookiebox.getCookie("uname").getValue()%>
	</div>
	
	<%--
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				//if(cookies[i].getName().equals("uid")){
					out.println("<div> " + cookies[i].getName() + "=" + cookies[i].getValue() + " </div>");
				//}
			}
		}
	--%>
	<a href="editCookie.jsp">쿠키값 수정하기</a>
	<a href="deleteCookie.jsp">쿠키값 삭제하기</a>
</body>
</html>