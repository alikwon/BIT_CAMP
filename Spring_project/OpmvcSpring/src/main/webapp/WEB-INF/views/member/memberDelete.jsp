<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${resultDel==1}">
	<script>
		alert('삭제됐음요');
		location.href='${pageContext.request.contextPath}/';
	</script>
</c:if>
<c:if test="${resultDel<1}">
	<script>
		alert('비번 틀리심');
		location.href ='mypage';
	</script>
</c:if>
