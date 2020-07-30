<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring MVC@
</h1>
	<ul>
		<li><a href="<c:url value='/hello'/>">헬로</a></li>
		<li><a href="<c:url value='/bye'/>">바이</a></li>
		<li><a href="<c:url value='/login/login'/>">로그인(GET)</a></li>
		<!-- 링크를 통한 페이지 이동은 GET방식임 -->
	</ul>
</body>
</html>
