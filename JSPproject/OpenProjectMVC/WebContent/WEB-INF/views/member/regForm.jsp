<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REG FORM</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<form id="regForm" action="memberReg.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td>
						<input type="email" name="uid" id="uid" required/>
						<span id="checkmsg"></span>
						<!-- 체크가 되어잇는지 안되어있는지 확인 -->
						<input type="checkbox" name="idchk" id="idchk"/>
					</td>					
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw" required/></td>					
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" required/></td>					
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="uphoto"/></td>					
				</tr>
				<tr>
					<td></td>
					<td>
					<input type="submit" value="회원가입"/>
					<input type="reset" value="초기화"/>
					</td>					
				</tr>
			</table>
		</form>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script>
	$(document).ready(function(){
		$('#regForm').submit(function(){
			if(!$('#idchk').prop('checked')){
				alert('아이디 재입력이 필요합니다');
				$('#uid').focus();
				return false;
			}
		});
		$('#uid').focusin(function(){
			$(this).val('');
			$('#idchk').prop('checked',false);
			
			$('#checkmsg').text('');
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
			
		});
		$('#uid').focusout(function(){
			if($(this).val().length<1){
				$('#checkmsg').text('아이디는 필수항목입니다');
				$('#checkmsg').addClass('check_not');
				$('#idchk').prop('checked',false);
				return false;
			}
			$.ajax({
				url:'idCheck.do',
				data:{ uid: $(this).val()},
				success : function(data){
					if(data=='Y'){
						$('#checkmsg').text('사용가능한 아이디입니다');
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked',true);
						
					}else{
						$('#checkmsg').text('사용할 수 없는 아이디입니다');
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked',false);
					}
				}
			});
		});
	});
</script>
</body>
</html>









