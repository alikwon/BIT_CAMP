package com.aia.mangch.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aia.mangch.model.Message;
import com.google.gson.Gson;

public class EchoHandler extends TextWebSocketHandler {
	private String url = "";
	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);

	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private Map<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("{} 유저가 접속을 시도합니다.", session.getId());
		
	}
	
	//접속한 uri가 채팅서버를 통해 접속한것인지 확인
	public void CheckUri(WebSocketSession session,Message msg) throws Exception {
		if(msg.getUrl().equals("/mangh/WEB-INF/views/chatting/chatting3.jsp")) {
			sessionList.add(session);
			//올바른 접속이면 맵에 저장 --> 닉네임을 키값으로 소켓세션저장
			sessionMap.put(msg.getSender(), session);
			logger.info("인증완료 ! {}님이 연결됐습니다.",msg.getSender()+"("+session.getId()+")");
			for(WebSocketSession s : sessionList) {
				System.out.println("현재 접속중인 참여자 : "+s.getId());
			}
		}else {
			System.out.println("이상한데서 왔네? 꺼지셈");
			session.close();
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Gson gson = new Gson();
		Message msg = gson.fromJson(message.getPayload(), Message.class);
		WebSocketSession ws = null;
		System.out.println(msg.toString());
		//1.서버에 접속했을 경우
		if(msg.getCode().equals("connection")) {
			logger.info("{} 의 인증정보를 받았습니다.", session.getId());
			CheckUri(session, msg);
		
		//2.메세지를 보내는 경우
		}else if(msg.getCode().equals("message")){
			logger.info("{}의 메세지를 받았습니다", msg.getSender()+"("+session.getId()+")");
			//전달할 메시지
			TextMessage sendMsg = new TextMessage(gson.toJson(msg));
			//상대방이 채팅서버에 접속해있으면
			if(sessionMap.get(msg.getReceiver())!=null) {
				//전달 받을 사람의 소켓세션을 찾고
				ws = sessionMap.get(msg.getReceiver());
				System.out.println(sessionMap.get(msg.getReceiver()));
				//상대방에게 메세지전달
				ws.sendMessage(sendMsg);
			}
			//나에게도 메세지전달
			session.sendMessage(sendMsg);
		}else if(msg.getCode().equals("delete")) {
			String html = "";
			html +="<div class='w3-cell-row w3-container w3-center'>";
			html +="	<p class='w3-round-xxlarge w3-red'>상대방이 채팅을 종료했습니다.<br> 메세지를 보낼 수 없습니다</p>";
			html +="	<button class='w3-button w3-large w3-round-large w3-red delChatRoom'>삭제</button>";
			html +="</div>";
			msg.setText(html);
			logger.info("{}가 채팅방 삭제를 요청합니다", msg.getSender()+"("+session.getId()+")");
			TextMessage sendMsg = new TextMessage(gson.toJson(msg));
			if(sessionMap.get(msg.getReceiver())!=null) {
				//전달 받을 사람의 소켓세션을 찾고
				ws = sessionMap.get(msg.getReceiver());
				//상대방에게 메세지전달
				ws.sendMessage(sendMsg);
			}
		}
		
//		//전체메세지
//		for (WebSocketSession webSocketSession : sessionList) {
//			webSocketSession.sendMessage(new TextMessage(message.getPayload()));
//		}

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		Iterator<String>itr = sessionMap.keySet().iterator();
		String key=null;
		while(itr.hasNext()) {
			key = itr.next();
			if(sessionMap.get(key)==session) {
				logger.info("{}가 접속이 종료됐습니다",key+"("+sessionMap.get(key)+")");
				sessionMap.remove(key);
				break;
			}
		}
		
	}
}
