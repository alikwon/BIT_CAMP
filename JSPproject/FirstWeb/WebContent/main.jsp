<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Test</title>
<style>
	header {
		text-align: center;
	}
	
	#wrap{
		overflow: hidden;
	}
	
	#news{
		width:45%;
		float: left;
	}
	#shopping {
		width:45%;
		float: right;
	}
</style>
</head>
<body>
	<!-- include 지시어 -->
	<%@ include file = "includeTest/header.jsp" %>
	<div id="wrap">
	<%@ include file = "includeTest/news.jsp" %>
	<%@ include file = "includeTest/shopping.jsp" %>
	</div>
	
	<!-- include 액션 -->
	<jsp:include page="includeTest/footer.jsp">
		<jsp:param value="son@gmail.com" name="email"/>
		<jsp:param value="010-9999-8888" name="tel"/>
	</jsp:include>
	
	
</body>
</html>