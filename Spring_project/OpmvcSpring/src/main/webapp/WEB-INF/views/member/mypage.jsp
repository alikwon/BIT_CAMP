<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY PAGE</title>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
<style>
img {
	width : 200px;
}
</style>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${loginInfo.uid}</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td>${loginInfo.upw}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${loginInfo.uname}</td>
		</tr>
		<tr>
			<td>사진</td>
			<td><img src="<c:url value="/${loginInfo.uphoto}"/>"></td>
		</tr>
		<tr>
			<td>가입날짜</td>
			<td>${loginInfo.regdate}</td>
		</tr>
	</table>
	</div>
	<form name="test">
		<input type="hidden" name="uid"/> 
		<input type="hidden" name="upw"/> 
	</form>
	<div class="edit_del_div">
	<a href="memberEdit" id="">회원정보수정</a>
	<%-- <a href="javascript:page_move('${loginInfo.uid}','${loginInfo.upw}')">수정폼</a> --%>
	
	&nbsp;&nbsp;&nbsp;
	<a href="#none" id="mbDel" onclick="mbDel()">탈퇴</a>
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script>
	
	function mbDel(){
		if(confirm("정말로 삭제할거임??")){
			location.href='memberDel';
		}else{
			location.href='mypage';
		}
	}
 	function page_move(uid,upw){
	    var f = document.test; //폼 name
	    f.uid.value = uid; //POST방식으로 넘기고 싶은 값
	    f.upw.value = upw; //POST방식으로 넘기고 싶은 값
	    f.action="memberEditForm";//이동할 페이지
	    f.method="post";//POST방식
	    f.submit();
	}


</script>
</body>
</html>