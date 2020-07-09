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
	<c:if test="${resultCode == 1}">
	<h1>메세지가 삭제됐음</h1>
	</c:if>
	<c:if test="${resultCode == -2}">
	<h1>비번이 안맞음</h1>
	</c:if>
	<c:if test="${resultCode == -1}">
	<h1>게시물이 없음요</h1>
	</c:if>
	<a href="list.jsp">홈으로</a>
</body>
</html>