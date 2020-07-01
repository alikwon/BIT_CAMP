<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//로그아웃 : session객체를 소멸시킴
	session.invalidate();
	//로그아웃 후 메인페이지로
	response.sendRedirect("../index.jsp");
%>