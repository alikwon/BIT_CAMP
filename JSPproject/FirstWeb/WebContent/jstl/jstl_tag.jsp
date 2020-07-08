<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setAttribute("price", 10000);
	request.setAttribute("now", new Date());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	2020.07.07
	JSTL 2일차
 -->
<%--<c:forEach var="id" items="<%= java.util.TimeZone.getAvailableIDs() %>">
		${id}<br/>
	</c:forEach> --%>
 	날짜 포멧팅<br>
 	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd a h:mm z" /> <br>
 	<hr>
 	날짜 시간 동시표현<br>
 	<fmt:formatDate value="${now}" type="both"/><br>
 	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
 	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
 	<hr>
 	날짜 표현<br>
 	<fmt:formatDate value="${now}"/><br>
 	<fmt:formatDate value="${now}" type="date"/><br>
 	<fmt:formatDate value="${now}" type="date" dateStyle="full"/> (full)<br>
 	<fmt:formatDate value="${now}" type="date" dateStyle="short"/> (short)<br>
 	<hr>
 	시간표현
 	<fmt:formatDate value="${now}" type="time"/><br>
 	<fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>
 	<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
 	<hr>
 	<hr>
	<c:set var="number" value="${10000}"/>
	<fmt:formatNumber value="${price}" type="number"/>
	<!-- numberType변수명으로 저장 -->
	<fmt:formatNumber value="${price}" type="number" var="numberType"/>
	${numberType}
	
	<br>
	통화 : <fmt:formatNumber value="${price}" type="currency"/>,
	<fmt:formatNumber value="${price}" type="currency" currencySymbol="$"/>
	
	<br>
	퍼센트 : <fmt:formatNumber value="${price/30000}" type="percent"/>
	<!-- groupingUsed==false >> 콤마가 빠짐 -->
	<fmt:formatNumber value="${price}" type="percent" groupingUsed="false"/>
	
	<br>
	패턴 : <fmt:formatNumber value="${price}" pattern="00000000.00"/>
	
<!-- 
	2020.07.06
	JSTL 기본
 -->
 	<hr>
 	<hr>
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
		<%-- <c:redirect url="${reUrl}">
			<c:param name="month">7</c:param>
		</c:redirect> --%>
	</h1>
</body>
</html>