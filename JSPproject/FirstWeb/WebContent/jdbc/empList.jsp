<%@page import="service.EmpListService"%>
<%@page import="Dao.EmpDao"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Emp"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP LIST</title>
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
</head>
<body>
	<%

		List <Emp> empList =EmpListService.getInstance().getEmpList();
		request.setAttribute("empList", empList);

	%>
	<%-- <jsp:forward page="empList_view"/> --%>
	
	<%-- ${empList} --%>
	
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