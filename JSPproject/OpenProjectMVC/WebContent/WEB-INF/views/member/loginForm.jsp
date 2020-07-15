<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER LIST</title>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>
		<h1>로그인</h1>
		<form action="login.do" method="post">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="uid" value=""><br></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw"><br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="chk" > ID저장</td>
					<td><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script>

</script>
</body>
</html>