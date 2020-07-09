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
		Cookie[] cookies = request.getCookies();
	
		for(int i=0;i<cookies.length;i++){
			String str = cookies[i].getName();
			if(str.equals("cookieN")){
				out.println("쿠키네임"+cookies[i].getName()+"<br>");
				out.println("쿠키벨류"+cookies[i].getValue()+"<br>");
			}
		}
	%>
	<a href="cookiedel.jsp">cookie delete</a>
</body>
</html>