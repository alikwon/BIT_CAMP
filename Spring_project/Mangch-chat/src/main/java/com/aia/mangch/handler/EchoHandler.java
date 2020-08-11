package com.aia.mangch.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aia.mangch.model.Member;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {
	
	// 세션 리스트
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	Map<String, WebSocketSession> userSessions = new HashMap<String, WebSocketSession>();
	
	// 클라이언트가 연결 되었을 때 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		String senderId= getId(session);
		userSessions.put(senderId, session);
		logger.info("{} 연결됨", session.getId());
	}

	// 클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
        String senderId = getId(session);
        
        //모든 유저에게 메세지 출력
        for(WebSocketSession sess : sessionList){
            sess.sendMessage(new TextMessage(message.getPayload()));
        }
	}

	private String getId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		Member loginUser = (Member)httpSession.get("loginInfo");
		if(loginUser ==null) {
			return session.getId();
		}else {
			return loginUser.getNick();
		}
	}

	// 클라이언트 연결을 끊었을 때 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} 연결 끊김.", session.getId());
	}

}