<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 게시물 비밀번호 확인</title>
<script>
	const form = document.getElementById('delForm');
	function check(){
		if(confirm('진짜 삭제할 거임?')){
			return true;
		}else{
			return false;
		}	
	};
</script>
</head>
<body>
	<h3>메세지를 삭제하려면 비번입력좀요</h3>
	<form id="delForm" action="deleteMessage.jsp" method="post" onsubmit="return check()">
		비밀번호 <input type="password" name="pw">
		<input type="hidden" name="mid" value="${param.mid}">
		<input type="submit" value="삭제하기">
	</form>
</body>
</html>