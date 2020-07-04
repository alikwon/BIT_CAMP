<%@page import="util.Info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("id");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	
	Info chkId = (Info) application.getAttribute(uid);
	boolean mJoin = false;
	if (chkId == null) {
		mJoin = true;
	}
	if(mJoin){
		application.setAttribute(uid, new Info(uid, pw, email));
%>
		<script>
			alert("가입 되엇습니다");
			location.href = '<%=request.getContextPath()%>/index.jsp';
		</script>
<%	} else {%>
		<script>
			alert("중복된 아이디 입니다. \n 다시가입해주세요");
			history.go(-1)
		</script>
<%	}%>
