<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result==1}">
	<script>
		alert('수정됐음요');
		location.href="${pageContext.request.contextPath}/index.do";
	</script>
</c:if>
<c:if test="${result<1}">
	<script>
		alert('수정실패요');
		location.href ='mypage.do';
	</script>
</c:if>
