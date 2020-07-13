<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result>0}">
		이름 : ${report.sname}<br>
		학번 : ${report.sno}<br>
		${report.report}<br>
		<img src="<c:url value="${report.report}"/>"/>
	</c:if>
	<c:if test="${result ==0}">
		<h1>저장실패</h1>
	</c:if>

</body>
</html>