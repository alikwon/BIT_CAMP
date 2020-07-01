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
<title>사용자의 요청정보 출력</title>
</head>
<body>
	<h1>전송결과</h1>
	<hr>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("username")%></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%=request.getParameter("userjob")%></td>
		</tr>
		<tr>
			<td>관심사</td>
			<td>
				<%
					String[] likes = request.getParameterValues("like");
				for (int i = 0; i < likes.length; i++) {
					out.println(likes[i] + "<br>");
				}
				%> <%--= request.getParameter("like") --%>
			</td>
		</tr>
		<tr>
			<td>요청 메서드</td>
			<td><%= request.getMethod() %></td>
		</tr>
		<tr>
			<td>쿠키정보</td>
			<td>
				<% 
					//Cookie = getName(), getValue()
					Cookie[] cookies = request.getCookies(); 
					for(int i=0; i<cookies.length;i++){
						out.println(cookies[i].getName());
						out.println(cookies[i].getValue());
						out.println(cookies[i]);
					}
				%>
			</td>
		</tr>
		<tr>
			<td>요청 정보</td>
			<td>
				<%= request.getProtocol() %><br>
				<!-- URL : 주소 다가져옴 -->
				<!-- URI : localhost:8080 뒤 주소 가져옴 -->
				<%= request.getRequestURL() %><br>
				<%= request.getRequestURI() %>
			</td>
		</tr>

	</table>
</body>
</html>