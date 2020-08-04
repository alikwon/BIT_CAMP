<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE CONFIRM</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
<style>
</style>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
		<h1>비밀번호 확인</h1>
		<div>
			<form action="memberDel" method="post">
				<input type="password" name="chkpw"/>
				<input type="submit" value="확인"/>
			</form>
		</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>

</html>