<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String pw = request.getParameter("pw");	
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age >=20){%>
		<jsp:forward page="pass_fw.jsp"></jsp:forward>
<%
	}else{
%>
		<jsp:forward page="pass_fw.jsp"></jsp:forward>
<%
	}
%>
