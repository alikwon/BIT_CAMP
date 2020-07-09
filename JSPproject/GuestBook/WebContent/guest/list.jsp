<%@page import="guestbook.model.MessageListView"%>
<%@page import="guestbook.service.GetMessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pageNum = 1; //list.jsp?page=kkk (X)
	String pageNumber = request.getParameter("page");
	if(pageNumber != null){
		pageNum = Integer.parseInt(pageNumber);
	}

	GetMessageListService gmls = GetMessageListService.getInstance();
	
	//MessageListView
	MessageListView view = gmls.getMessageList(pageNum);
	
	request.setAttribute("listView", view);
%>
<jsp:forward page="list_view.jsp"/>