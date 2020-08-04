<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT FORM</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<form action="memberEdit" method="post" enctype="multipart/form-data">
		<div>
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>${loginInfo.uid} (아이디 수정 불가)</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="upw" value="${loginInfo.upw}"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" value="${loginInfo.uname}"/></td>
				</tr>
				<tr>
					<td>사진</td>
					<td>
						<input type="file" name="uphoto">
						<hr>
						현재 사진 <br><img src="<c:url value="${loginInfo.uphoto}"/>">
					</td>
				</tr>
				<tr>
					<td>가입날짜</td>
					<td>${loginInfo.regdate}</td>
				</tr>
			</table>
			<input type="hidden" name="uid" value="${loginInfo.uid}">
			<input type="hidden" name="oldphoto" value="${loginInfo.uphoto}">
		</div>
		<div class="edit_del_div">
			<input type="submit" value="수정하기"/>
		</div>
	</form>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>