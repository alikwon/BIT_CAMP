<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<% 
		//스크립트릿 영역 : java 코드 작성 앞으로 사용하지 않는당
		//지금은 걍 보여주는것
		Date now = new Date();
	%>
	<!-- 표현식 -->
	<!-- "=" println 과 같다 -->
	<%= now %>
	<br>
	오늘의 날짜와 시간은 : 
	<%= new java.util.Date() %>

</body>
</html>