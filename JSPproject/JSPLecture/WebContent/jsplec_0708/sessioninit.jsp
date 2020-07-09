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
		session.setAttribute("sessionN", "sessionD");
		session.setAttribute("mynum", 12345);
	%>
	<a href="sessionget.jsp">sessionget</a>
</body>
</html>