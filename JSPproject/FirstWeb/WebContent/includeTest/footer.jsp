<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer>
	<!-- 사용자가 보낸 정보중에 파라미터 email을 받음 -->
	email : <%= request.getParameter("email") %>
	<br>
	tel : <%= request.getParameter("tel") %>
</footer>