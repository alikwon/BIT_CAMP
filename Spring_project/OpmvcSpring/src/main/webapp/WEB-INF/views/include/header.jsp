<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
	<h1 id="header">Open Project</h1>
	<ul id="nav">
		
		<li><a href="<c:url value="/"/>">홈</a></li>
		<c:if test="${!empty loginInfo}">
			<li><a href="<c:url value="/member/logout"/>">로그아웃</a></li>
			<li><a href="<c:url value="/member/mypage"/>">마이페이지</a></li>
			<li><a href="<c:url value="/board/list.jsp"/>">방명록(회원제)</a></li>
		</c:if>
		
		<c:if test="${empty loginInfo}">
			<li><a href="${pageContext.request.contextPath}/member/memberReg">회원가입</a></li>
			<li><a href="<c:url value="/member/login"/>">로그인</a></li>
		</c:if>
		
		<li><a href="<c:url value="/guestbook/list.jsp"/>">방명록(비회원)</a></li>
		<c:if test="${!empty loginInfo}">
		</c:if>
			<li><a href="<c:url value="/member/memberList"/>">전체회원목록</a></li>
			<li><a href="<c:url value="/member/memberList.xml"/>">XML회원목록</a></li>
	</ul>
	
	
	
	
	
	