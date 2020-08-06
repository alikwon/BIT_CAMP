<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER LIST</title>
</head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
<style>
table{
	margin-top: 20px;
	margin-left: 30px;
	width: 80%;
}
td{
	text-align: center;
	width: 20%;
	padding: 10px;
}
.category{
	
	font-weight: bold;
}
.list_num{
		float: left;
		margin-right : 15px;
		background-color: white;
		border-radius: 5px;
		opacity: 0.8;
}
.paging{
	padding-left : 30%;
	margin-left: 30px;
	margin-top: 15px;
	align-items: center;
	height: 40px;
}

.list_num_sel{
	font-size: 1.5em;
	font-weight: bold;
	float: left;
	margin-right : 15px;
	background-color: white;
	border-radius: 5px;
	opacity: 0.8;
}
.list{
	width : 100%;
	height: 400px;
}
#thumbnail{
	width : 40px;
}

div.searchBox{
	
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="searchBox">
		<form>
			<select name="searchType">
				<option value="id">id</option>
				<option value="name">name</option>
				<option value="both">id+name</option>
			</select>
			<input type="text" name="keyword"/>
			<input type="submit" value="검색">
		</form>
	</div>
	<div class="list">
		<c:if test="${not empty listView.memberList}">
		<table border="1">
			<tr class="category">
				<td>아이디</td>
				<td>이름</td>
				<td>사진</td>
				<td>가입날짜</td>
				<td>보기</td>
				
			</tr>
			<c:forEach items="${listView.memberList}" var="member">
				<tr class="member_box">
					<td>${member.uid}</td>
					<td>${member.uname}</td>
					<td><img src="<c:url value="/${member.uphoto}"/>" id="thumbnail"/></td>
					<td>${member.regdate}</td>
					<td><a href="view/${member.idx}">상세</a>
		<%-- 			<td><a href="memberDel.do?delid=${member.uid}">삭제</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</div>
	
	<div class="paging">
	<c:if test="${listView.pageTotalCount > 0}">
		<c:forEach var="num" begin="1" end="${listView.pageTotalCount}">
			<div class="${listView.currentPageNumber == num? 'list_num_sel':'list_num'}"><a href="memberList?page=${num}&searchType=${param.searchType}&keyword=${param.keyword}" >&nbsp;${num}&nbsp;</a></div>
		</c:forEach>
	</c:if>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>