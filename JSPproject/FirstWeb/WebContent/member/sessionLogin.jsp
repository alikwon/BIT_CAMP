<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//로그인 처리
	// 아이디의 값과 비밀번호의 값을 문자열 비교해서 같으면 로그인처리(session 속성)
	// 1.아이디, 비밀번호 데이터를 받는다
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	// 2.로그인을 위한 비교 : 아이디 비밀번호 문자열 비교
	boolean loginChk = false;	
	if(uid.equals(pw)){
		// 3.로그인 처리 : 세션에 사용자 정보를 저장
		//session.setAttribute("memberId", uid);
		session.setAttribute("memberInfo", new MemberInfo(uid,pw));
		loginChk = true;
	}
	// 4.응답 처리 : html 로그인처리 일 때 , 로그인이 되지 않았을 때 
%>
<%
	//로그인 됐을때 html 실행
	if(loginChk){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 됐어요</h1>
	<h2>id : <%= uid %>, pw: <%= pw %></h2>
	<a href="mypage.jsp">마이페이지</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>
<%
}else{
%>
<script>
	alert("아이디 또는 비밀번호를 확인해주세요");
	//이전페이지
	history.go(-1);
</script>
<%
}
%>
