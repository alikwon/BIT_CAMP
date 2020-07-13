<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="joinok.jsp" method="post">
		ID : <input type="text" name="id" /><br>
		이름 : <input type="text" name="name" /><br> 
		비번 : <input type="password" name="pw" /><br>
		성별 : <input type="radio" name="gender" value="male"/>남자 
		<input type="radio" name="gender" value="female"/>여자<br>
		<input type="submit" value="전송" />
	</form>
</body>
</html>