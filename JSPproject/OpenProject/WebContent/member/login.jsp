<%@page import="util.MemberInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("id");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("chk");
	
	String cookieName="uid";
	String cookiePath = request.getContextPath();
	
	if (chk != null) {
		response.addCookie(CookieBox.createCookie(cookieName, uid, cookiePath, 60*60*24*365));		
	} else {
		//원래 있던 uid라면 소멸시킴
		response.addCookie(CookieBox.createCookie(cookieName, uid, cookiePath, 0));	
	}
	
	boolean loginChk = false;
	MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
	if(memberInfo==null){
		session.setAttribute("memberInfo", new MemberInfo(uid,pw));
		loginChk =true;
	}
	
	if(loginChk){
%>
<script>
	alert("로그인 되엇습니다");
	location.href = '<%= request.getContextPath()%>/index.jsp';
</script>
<%
}
%>

