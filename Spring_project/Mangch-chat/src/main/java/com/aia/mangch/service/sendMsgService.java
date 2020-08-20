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
	
	public ChatMsgInfo sendMsg(InsertChatMsgInfo insertInfo, ChatRoomInfo chatRoom, HttpServletRequest req) {
		dao=st.getMapper(ChatDao.class);
		ChatMsgInfo chat= insertInfo.setChatMsgInfo();
		MultipartFile image = insertInfo.getMsgPhoto();
		int roomIdx = chat.getRoomIdx();
		//채팅방없이 첫 메세지일 경우 roomIdx를 -1로 설정했음 ==>채팅방생성
		if (chat.getRoomIdx() ==-1) {
			dao.createChatRoom(chatRoom);
			//insert하고 새로생긴 채팅방의 idx가 chatRoom에 담김
			chat.setRoomIdx(roomIdx=chatRoom.getIdx());
		}
		try {
			//사진이 있을땐 파일저장후 경로를 ChatMsgInfo객체에 저장하고
			if (image != null && image.getSize() > 0 && !image.isEmpty()) {
				//이미지 저장폴더
				String folder="/room"+roomIdx;
				String uri = "/resources/image"+folder;
				String folderPath = req.getSession().getServletContext().getRealPath(uri);
				
				File file = new File(folderPath);
				//폴더가 없으면 생성
				if(!file.exists()) {
					file.mkdir();
					System.out.println("폴더 생성됐음요");
				}
				// 파일 덮어쓰면 안되니까 앞에 나노초 붙여줌
				String newImgName = System.nanoTime() + "_" + image.getOriginalFilename();// 사진이름경로
				file = new File(folderPath, newImgName);
				image.transferTo(file);
				System.out.println("저장완료" + newImgName);

				// 웹경로
				chat.setImg(newImgName);
			} else {
				//사진이 없을땐 텍스트를 ChatMsgInfo에 저장한다
				chat.setText(insertInfo.getText());
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
		return chat;
	}

}
