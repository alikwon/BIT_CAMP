<%@page import="guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="requestMessage" class="guestbook.model.Message" scope="request"/>
<jsp:setProperty property="*" name="requestMessage"/>
<%
	WriteMessageService wms = WriteMessageService.getInstance();
	int result = wms.writeMessage(requestMessage);
	request.setAttribute("writeResult", result);
%>
<jsp:forward page="messageWrite_view.jsp"></jsp:forward>