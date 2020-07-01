<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userName = (String)session.getAttribute("username");
%>
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
	<br>
	현재 접속중인 사용자의 이름 : <%= userName %>
	<br>
	
	<!-- 갱신 -->
	<%
		session.setAttribute("username", "KING");
	%>
	<a href="session/sessionView01.jsp">KING으로 다시 set</a>
</body>
</html>