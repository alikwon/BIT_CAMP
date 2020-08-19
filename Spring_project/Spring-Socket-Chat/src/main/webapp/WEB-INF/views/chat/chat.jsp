<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.text_right {
		text-align: right;
	}
	
	.text_left {
		text-align: left;
	}
	.chattingBox {
		padding : 15px;
		border : 1px solid #AAA;
		margin: 10px 0;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${getContextPath}/resources/plugins/stomp/stomp.min.js"></script>
<script src="${getContextPath}/resources/plugins/sockjs-client/sockjs.min.js"></script>

<!-- Zebra-Dialog CDN -->
<!-- <script src="resources/js/dialog/zebra_dialog.src.js"></script>
<link rel="stylesheet" href="resources/css/dialog/zebra_dialog.css" type="text/css" /> -->

</head>
<body>
<script>
var user = '${user}';

$(function(){
	initWebsocket();
	initEvent();
});

function initEvent() {
	$('#connect').on('click', function(){
		connectClient();

	});
	$('#p2pMessage').on('click', function(){
			
	});
	$('#broadMessage').on('click', function(){
		var message = $('#message').val();
		$.ajax({
			url:'/socket/broadMessage',
			type:'post',
	/* 		dataType : "json",
			contentType: "application/json", */
			data:{user:user, message:message},
			success:function(data) {
				
			}
		});
	});
}

function disconnectWebsocket() {
	ws.close();
	initWebsocket();
	
}

function initWebsocket() {
	console.log("initWebsocket");
	// 웹소켓
	var portStr = "";
	if (location.port.length == 0) {
		portStr = ":80";
	}
	else {
		portStr = ":" + location.port;
	}
	
	var protocolStr = "ws";
	if (location.protocol == 'https') {
		protocolStr = "wss";
	}

	var wsUrl = protocolStr + "://" + location.hostname + portStr + "/socket/push";
	
	ws = new WebSocket(wsUrl);

	ws.addEventListener('close',disconnectWebsocket);
	
	var client = Stomp.over(ws);
	
	//웹소켓 console.log 비활성화
	client.debug = null;
	client.connect({}, function(frame) {
		console.log('isConnected')
		// 특정 클라이언트 이벤트
		client.subscribe('/user/${user}/event', function(message) {
			
		});
		
		// 전체 이벤트
		client.subscribe('/topic/event', function(message) {
			console.log(message);
			
			var event = JSON.parse(message.body);
			
			$('#chatArea').append(event.payload+"\n");
		});
	});
}

function connectClient() {
	
	$.ajax({
		url:'/socket/chattingConnection',
		type:'post',
/* 		dataType : "json",
		contentType: "application/json", */
		data:{user:user},
		success:function(data) {
			
		}
	});
}
</script>
	<h1>Chatting Page (id: ${user})</h1>
	<br>
	<div>
		<div>
	
			<input type="text" id="message" /> 
			
			<button type="button" id="connect">접속</button>
			<button type="button" id="p2pMessage">귓속말</button>
			<button type="button" id="broadMessage">전체메시지</button>
		</div>
		<br>
		<div class="well" id="chatdata">
			<!-- User Session Info Hidden -->
			<input type="hidden" value='${user}' id="sessionuserid">
		</div>
		<textarea rows="10" cols="10" id='chatArea'></textarea>
	</div>
</body>


<script>
	
</script>
</html>