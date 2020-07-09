<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 결과</title>
</head>
<style>
	body{
	    background-color: #2c3e50;
	}
	.bgImage{
	    position: absolute;
	    top:0;
	    left: 0;
	    width: 100%;
	    height: 100%;
	    /* 
	    z축 인덱스값설정
	        더 큰 z-index 값을 가진 요소가 작은 값의 요소 위를 덮습니다
	        음수 값으로 우선순위를 낮출수 잇음
	    */
	    z-index: -1;
	    filter: brightness(70%);
	    animation: fadeIn .3s linear;
	}
</style>
<body>
	<c:if test="${writeResult > 0}">
		<h1>글이 정상적으로 작성되었습니다</h1>
	</c:if>
	
	<c:if test="${writeResult == 0}">
		<h1>글쓰기 실패!!!</h1>
	</c:if>
	<a href="list.jsp">목록으로</a>
	<img src="https://images.unsplash.com/photo-1568897451406-94d62ae18aea?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80" class="bgImage"/>
</body>
</html>