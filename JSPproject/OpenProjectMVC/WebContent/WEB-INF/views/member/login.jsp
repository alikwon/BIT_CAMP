<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN RESULT</title>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<c:if test="${loginChk==0}">
		<script>
			alert('등록되지 않은 회원입니다');
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${loginChk==1}">
		<h1>로그인 성공!</h1>
		<h2>${uid} 님 안녕하세요!</h2>
	</c:if>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>