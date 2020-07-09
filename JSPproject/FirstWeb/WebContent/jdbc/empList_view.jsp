<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{
		width:80%;
	}
	table td{
		padding:10px;
		padding-left: 40px;
	}
	th{
		padding:15px;
	}
</style>
<body>
<table border="1">
		<tr>
			<th>사원 번호</th>
			<th>사원 이름</th>
			<th>사원 급여</th>
			<th>사원 직급</th>
			<th>사원 부서</th>
		</tr>
		<c:if test="${empty empList}">
			<tr>
				<td colspan="5">데이터가 존재하지 않습니다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ</td>
			</tr>
		</c:if>
		<c:if test="${not empty empList}">
			<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.sal}</td>
				<td>${emp.job}</td>
				<td>${emp.deptno}</td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>