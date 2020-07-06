<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	2020.07.06
	JSTL 기본
 -->
 	<c:out value="jstl tag out --> 데이터를 출력합니다."/>
	<br>
	<c:out value="${members[1].name}"/>
	
	<c:out value="${members[7].email}" 
		   default="<i>이메일없음</i>" 
		   escapeXml="false"/>
		   
	<c:out value="${members[8].email}" escapeXml="false">
		<span style="color:red;">이메일 없음</span>
	</c:out>
	
	<c:forEach 
		items="${applicationScope.members}"
		var = "member"
		varStatus="status">
		<h3>
		${status.index} ${status.count}
		이름 : ${member.name}<br> 이메일: 
		<c:out value="${member.email}" escapeXml="false">
			<span style="color:red;">이메일없음</span>
		</c:out>
		<c:if test="${member.email==null}">
			<span style="color:blue;">이메일 없음</span>
		</c:if>
		<c:if test="${empty member.email}">
			<span style="color:green;">이메일 없음</span>
		</c:if>
		</h3>
	</c:forEach>
	
	<c:forTokens items="손흥민,010-7777-1111,런던" delims="," var="token">
		${token}<br>
	</c:forTokens>
	
	<hr>
	<h1>
	url1 : <c:url value="/index.jsp"/>
	<a href="<c:url value="/index.jsp"/>">홈</a>
	<br>
	url2 : <c:url value="jstl_tag2.jsp">
		<c:param name="year" value="1999"/>
	</c:url>
	<br>
	url3 : <c:url value="jstl_tag2.jsp?year=1999"/>
	<br>
	
	<!-- reUrl에 url 저장 -->
	<c:url value="jstl_tag2.jsp?year=2010" var="reUrl"/>
	url4 : ${reUrl}
	</h1>
	
	<h1 style="color:blue;">
		<c:redirect url="${reUrl}">
			<c:param name="month">7</c:param>
		</c:redirect>
	</h1>
</body>
</html>