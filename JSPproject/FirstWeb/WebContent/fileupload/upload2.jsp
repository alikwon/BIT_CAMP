<%@page import="service.ReportRegService"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ReportRegService rrs = ReportRegService.getInstance();
	int result = rrs.regReport(request);
	System.out.println(result);
	request.setAttribute("result", result);
%>
<jsp:forward page="upload_view.jsp"/>