<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- post를 쓰면 깨지기 때문에 request의 setChracterEncoding()메서드 사용-->
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자의 요청정보 출력2</title>
</head>
<body>
	<jsp:forward page="foward2.jsp"/>
	
</body>
</html>