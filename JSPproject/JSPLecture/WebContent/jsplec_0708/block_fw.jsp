<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>20세 미만 ㅂㅂ</h1>
	<%
		String age = request.getParameter("age");
		out.println(age);
	%>
</body>
</html>