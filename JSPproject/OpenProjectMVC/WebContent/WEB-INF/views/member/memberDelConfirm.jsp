<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE CONFIRM</title>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
<style>
</style>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
		<h1>비밀번호 확인</h1>
		<div>
			<form id="confirm" action="memberDel.do">
				<input type="password" name="upw"/>
				<input type="submit" value="확인"/>
			</form>
		</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script>
	$(document).ready(function(){
		$('#confirm').submit(function(){
			
		});
	});
</script>
</body>

</html>