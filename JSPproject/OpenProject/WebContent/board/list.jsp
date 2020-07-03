<%@ page import="util.MemberInfo" %>
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
<title>회원 방명록</title>
<style>
</style>
<!-- href 로드되는건 루트경로 잡아줘야함 -->
<link rel="stylesheet" href="/op/css/default.css" />
</head>
<body>
	<!-- 절대경로 / 쓰면 루트경로 -->
	<%@ include file="/include/header.jsp"%>

	<div>
		<h1>회원 방명록 입니다</h1>
	</div>
	<%@ include file="/include/footer.jsp"%>

</body>
</html>
<%}%>