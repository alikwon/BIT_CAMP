<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String sessionN = (String)session.getAttribute("sessionN");
		out.println("sessionN: "+sessionN+"<br>");
		int mynum = (Integer)session.getAttribute("mynum");
		out.println("mynum: "+mynum+"<br>");
		out.println("======================<br>");
		
		String sessionId = session.getId();
		out.println("sessionId"+sessionId+"<br>");
		int inter = session.getMaxInactiveInterval();
		out.println("inter"+inter+"<br>");
		out.println("======================<br>");
		
		session.removeAttribute("mynum");
		
		
		
	%>
</body>
</html>