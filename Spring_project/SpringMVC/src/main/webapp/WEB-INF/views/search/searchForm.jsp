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
	<h3>검색 ${searchType}</h3>
	<select>
	<c:forEach items="${searchType}" var="type">
		<option value="${type.tno}">${type.type}</option>
	</c:forEach>
	</select>
</body>
</html>