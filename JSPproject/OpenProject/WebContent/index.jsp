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
<link rel="stylesheet" href="/op/css/default.css"/>
</head>
<body>
	<!-- 절대경로 / 쓰면 루트경로 -->
	<%@ include file="/include/header.jsp" %>
	
	<div>
		<h1>홈 화면</h1>
		<img src="https://www.bloter.net/wp-content/uploads/2016/08/%EC%8A%A4%EB%A7%88%ED%8A%B8%ED%8F%B0-%EC%82%AC%EC%A7%84.jpg"/>
	</div>
	<%@ include file="/include/footer.jsp" %>

</body>
</html>