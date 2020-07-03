<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login result</title>
</head>
<body>
	<h1>로그인 정보</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%= request.getParameter("id") %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= request.getParameter("pw") %></td>
		</tr>
		<tr>
			<td>아이디 저장</td>
			<td>
			<%= request.getParameter("check")%>
			</td>
		</tr>
	</table>
</body>
</html>