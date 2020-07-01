<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>

</style>
<!-- href 로드되는건 루트경로 잡아줘야함 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css"/>
</head>
<body>
	<!-- 절대경로 / 쓰면 루트경로 -->
	<%@ include file="/include/header.jsp" %>
	
	<div>
		<h1>로그인</h1>
	</div>
	<%@ include file="/include/footer.jsp" %>

</body>
</html>