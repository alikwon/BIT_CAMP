<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 처리</h1>
		<table>
			<tr>
				<td>아이디</td>
				<td>${login.uid}</td>
			</tr>
			<tr>
				<td>비번</td>
				<td>${login.upw}</td>
			</tr>
		</table>
</body>
</html>