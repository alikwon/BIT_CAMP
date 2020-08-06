<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h1>상세정보</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${member.uid}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.uname}</td>
		</tr>
		<tr>
			<td>사진</td>
			<td><img src="<c:url value="/${member.uphoto}"/>"></td>
		</tr>
		<tr>
			<td>가입날짜</td>
			<td>${member.regdate}</td>
		</tr>
	</table>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>