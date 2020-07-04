<%@page import="util.Info"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo"%>
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
	Info mi = (Info)application.getAttribute(uid); 
	if(mi==null){
%>
		<script>
			alert('등록되지 않은 회원입니다');
			history.go(-1);
		</script>

<%
	}else if(!mi.getPw().equals(pw)){
%>
		<script>
			alert('비밀번호를 확인해주세요 ');
			history.go(-1);
		</script>

<%	
	}else{
		loginChk =true;		
	}
	MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
	if(memberInfo==null){
		session.setAttribute("memberInfo", new MemberInfo(uid,pw));
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

