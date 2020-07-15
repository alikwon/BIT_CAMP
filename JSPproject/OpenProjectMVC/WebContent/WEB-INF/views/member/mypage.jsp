<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY PAGE</title>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
<style>
</style>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${loginInfo.uid}</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td>${loginInfo.upw}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${loginInfo.uname}</td>
		</tr>
		<tr>
			<td>사진</td>
			<td><img src="<c:url value="${loginInfo.uphoto}"/>"></td>
		</tr>
		<tr>
			<td>가입날짜</td>
			<td>${loginInfo.regdate}</td>
		</tr>
	</table>
	</div>
	<div class="edit_del_div">
	<a href="memberEditForm.do">회원정보수정</a>
	&nbsp;&nbsp;&nbsp;
	<a href="memberDelConfirm.do">탈퇴</a>
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>