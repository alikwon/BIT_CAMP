<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Object 타입이기 때문에 형변환해줘야함
	String userName = (String)session.getAttribute("username");		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		session의 속성으로 저장한 데이터2<br>
		username : <%= userName %><br>
		<a href="../index.jsp">다른페이지</a>
		<a href="logout.jsp">로그아웃</a>
	</h1>
	
</body>
</html>