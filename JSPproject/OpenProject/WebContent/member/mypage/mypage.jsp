<%@page import="util.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Object 타입이라서 String으로 명시적 형변환
MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");

if (memberInfo == null) {
	//response.sendRedirect("sessionLoginForm.jsp");
%>
<script>
			alert('사용자 전용 페이지 입니다. \n 로그인해주세요');
			location.href = '<%=request.getContextPath()%>/index.jsp';
</script>
<%
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
<link rel="stylesheet" href="/op/css/default.css" />
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>로그인을 한 사용자를 위한 페이지 입니다.</h1>
	<table border="1" style="text-align: center;">
		<tr>
			<td>로그인 아이디</td>
			<td>로그인 비밀번호</td>
		</tr>
		<tr>
			<td><%=memberInfo.getUid()%></td>
			<td><%=memberInfo.getPw()%></td>
		</tr>
	</table>
	<a href="<%=request.getContextPath()%>/member/logout.jsp">로그아웃</a>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
<%
	}
%>