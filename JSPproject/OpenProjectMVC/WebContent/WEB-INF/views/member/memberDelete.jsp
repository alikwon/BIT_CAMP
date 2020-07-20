<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${resultDel==1}">
	<script>
		console.log(${pageContext.request.contextPath});
		alert('삭제됐음요');
		location.href='${pageContext.request.contextPath}/index.do';
	</script>
</c:if>
<c:if test="${resultDel<1}">
	<script>
		alert('비번 틀리심');
		location.href ='mypage.do';
	</script>
</c:if>
