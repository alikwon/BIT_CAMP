<%@page import="joinex.JoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mem" class="joinex.Member" scope="request"/>
<jsp:setProperty property="*" name="mem"/>
<%

	JoinService js = JoinService.getInstance();
	int result = js.joinMember(mem);
	request.setAttribute("result", result);
	
%>
<jsp:forward page="joinresult.jsp"></jsp:forward>