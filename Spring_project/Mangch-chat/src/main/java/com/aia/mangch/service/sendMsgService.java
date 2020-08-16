package com.aia.mangch.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.ChatRoomInfo;
import com.aia.mangch.model.InsertChatMsgInfo;

@Service
public class sendMsgService {
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public int sendMsg(InsertChatMsgInfo insertInfo, ChatRoomInfo chatRoom, HttpServletRequest req) {
		dao=st.getMapper(ChatDao.class);
		String msgImg = null;
		ChatMsgInfo chat= insertInfo.setChatMsgInfo();
		MultipartFile file = insertInfo.getMsgPhoto();
		try {
			//사진이 있을땐 파일저장후 경로를 ChatMsgInfo객체에 저장하고
			if (file != null && file.getSize() > 0 && !file.isEmpty()) {
				String uri = "/resources/image";
				String realPath = req.getSession().getServletContext().getRealPath(uri);

				// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장완료" + newFileName);

				msgImg = uri + "/" + newFileName; // 웹경로
				chat.setImg(msgImg);
				System.out.println("sendMsgService>>>>img : "+chat.getImg());
			} else {
				//사진이 없을땐 텍스트를 ChatMsgInfo에 저장한다
				chat.setText(insertInfo.getText());
			}

			//int existRoom = dao.roomExistChk(chat.getRoomIdx());
			//채팅방없이 첫 메세지일 경우 roomIdx를 -1로 설정했음 ==>채팅방생성
			if (chat.getRoomIdx() ==-1) {
				dao.createChatRoom(chatRoom);
				//insert하고 새로생긴 채팅방의 idx가 chatRoom에 담김
				chat.setRoomIdx(chatRoom.getIdx());
			}
			// chatMsg를 데이터 베이스 저장
			if(chat.getText()!=null&&chat.getText().length()>0) {
				dao.insertMsg(chat);
			}else {
				dao.insertMsgWithImg(chat);
			}
			// 최신채팅방을 위로 올리기위해 새로운메세지가 insert된 채팅방의 업데이트시간을 갱신
			dao.updateRoomDate(chat.getRoomIdx());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chat.getRoomIdx();
	}

}
