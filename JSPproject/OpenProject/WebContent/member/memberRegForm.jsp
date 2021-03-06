<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<style>

</style>
<!-- href 로드되는건 루트경로 잡아줘야함 -->
<link rel="stylesheet" href="/op/css/default.css"/>
</head>
<body>
	<!-- 절대경로 / 쓰면 루트경로 -->
	<%@ include file="/include/header.jsp" %>
	
	<div>
		<h1>회원가입</h1>
	<hr>
	<form action="join.jsp" method="post">
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td>
					<input type="text" name="id" required>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pw" required>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" required>
				</td>
			</tr>
			<!-- <tr>
				<td>사진</td>
				<td>
					<input type="file" name="uPhoto">
				</td>
			</tr> -->
			<tr>
				<td></td>
				<td>
					<input type="submit" value="등록">
					<input type="reset">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="/include/footer.jsp" %>

</body>
</html>