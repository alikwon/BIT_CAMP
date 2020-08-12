package com.aia.mangch.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {

	// 세션 리스트
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private Map<String,String> userSessions= new HashMap<>();
	// 클라이언트가 연결 되었을 때 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.info("{} 연결됨", session.getId());
	}

	// 클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String[] msg = message.getPayload().split("&");
        userSessions.put(session.getId(), msg[2]);
//        logger.info("{}번 개시글을 보고 온 {}로 부터 {} 받음", msg[0], msg[1]);
        System.out.println(msg[1]+"번게시글을 보고온 "+msg[2]+"가 "+msg[0]+"에게");
        //모든 유저에게 메세지 출력
//        for(WebSocketSession sess : sessionList){
//            sess.sendMessage(new TextMessage(message.getPayload()));
//        }
        
	}
	// 클라이언트 연결을 끊었을 때 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} 연결 끊김.", session.getId());
	}

}
