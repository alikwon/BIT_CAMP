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

</head>
<body>
	<%

		List <Emp> empList =EmpListService.getInstance().getEmpList();
		request.setAttribute("empList", empList);

	%>
	<jsp:forward page="empList_view.jsp"/>
	
	
</body>
</html>