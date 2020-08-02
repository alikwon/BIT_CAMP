<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REPORT FORM</title>
</head>
<body>
	<h1>@RequestParam을 이용한 File Upload</h1>
	<hr>
	<!-- 파일업로드는 무조건 post -->
	<form action="upload1" method="post" enctype="multipart/form-data">

	<table>
		<tr>
			<td>학번</td>
			<td><input type="text" name="sno"></td>
		</tr>
		<tr>
			<td>과제파일</td>
			<td><input type="file" name="report"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="제출"></td>
		</tr>
	</table>
	</form>
</body>
</html>