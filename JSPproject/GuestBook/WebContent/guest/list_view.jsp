<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book</title>
</head>
<style>
	
	table td{
		padding: 10px;
	}
	input, textarea {
		padding: 5px;
		opacity: 0.7;
		border-radius: 5px;
	}
	@keyframes fadeIn{
	    from{
	        opacity: 0;
	    }
	    to{
	        opacity: 1;
	    }
	}
	body{
	    background-color: #2c3e50;
	}
	.bgImage{
	    position: absolute;
	    top:0;
	    left: 0;
	    width: 100%;
	    height: 100%;
	    /* 
	    z축 인덱스값설정
	        더 큰 z-index 값을 가진 요소가 작은 값의 요소 위를 덮습니다
	        음수 값으로 우선순위를 낮출수 잇음
	    */
	    z-index: -1;
	    filter: brightness(70%);
	    animation: fadeIn .3s linear;

	}
	
	.msg_box{
		background-color: white;
		margin: 10px;
		padding: 10px;
		width: 300px;
		opacity: 0.8;
		border-radius: 10px;
	}
	td>label{
		color : white;
		font-weight:bold;
	}
	.list_num{
		float: left;
		margin-right : 15px;
		background-color: white;
		border-radius: 5px;
		opacity: 0.8;
	}
	.paging{
		margin-left: 15px;
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
	
	.write{
		display: none;
	}
	.show{
		display: block;
	}
	
</style>
<body>
	<h3>방명록 글 쓰기</h3>
	<hr>
	<button onclick="clicked()">글쓰기</button>
	<form class ="write" action="messageWrite.jsp" method="post">
		<table>
			<tr>
				<td><label for="uname">이름</label></td>
				<td><input type="text" id="uname" name="uname" required/></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호</label></td>
				<td><input type="password" id="pw" name="pw" required/></td>
			</tr>
			<tr>
				<td><label for="msg">메세지</label></td>
				<td><textarea id="msg" name="msg" rows="10" cols="22"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="글쓰기">&nbsp;
				<input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
	<hr>
	<!--  -->
	<c:if test="${not empty listView.msgList}">
		<c:forEach items="${listView.msgList}" var="message">
			<div class="msg_box">
				게시물번호 : ${message.mid}<br>
				작성자 : ${message.uname}<br>
				메세지 : <br>${message.msg}<br>
				<a href="deleteMessageConfirm.jsp?mid=${message.mid}">삭제</a> 
			</div>
		</c:forEach>
	</c:if>
	<div class="paging">
	<c:if test="${listView.pageTotalCount > 0}">
		<c:forEach var="num" begin="1" end="${listView.pageTotalCount}">
			<div class="${listView.currentPageNumber == num? 'list_num_sel':'list_num'}"><a href="list.jsp?page=${num}" >&nbsp;${num}&nbsp;</a></div>
		</c:forEach>
	</c:if>
	</div>
	<img src="https://images.unsplash.com/photo-1568897451406-94d62ae18aea?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80" class="bgImage"/>
<script>
	const a = document.querySelector(".write");
	const CLASS_NAME = "write show";
	function clicked(){
		const currClass = a.className;
		if(a.className !==CLASS_NAME){
    		a.className = CLASS_NAME
		}else{			
    		a.className = 'write';
		}
	}
</script>
</body>
</html>