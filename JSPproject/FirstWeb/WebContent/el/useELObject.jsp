<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//배열
	String[] bookNames = {"Java의 정석","HTML5 프로그래밍","ECMA6 Script"};
	request.setAttribute("bookNames", bookNames);
	
	//리스트
	List<String> study = new ArrayList<>();
	study.add("JAVA");
	study.add("ORACLE");
	study.add("웹표준");
	study.add("JSP");
	request.setAttribute("study", study);
	
	//맵
	Map<String, String> student= new HashMap();
	student.put("dept", "컴퓨터사이언스");
	student.put("name", "손흥민");
	student.put("phoneNumber", "010-0000-0000");
	request.setAttribute("student", student);
%>

<jsp:forward page="objectView.jsp"/>