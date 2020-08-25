package com.aia.mangch.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.DelChatRoomInfo;

@Service
public class ChatRoomDelService {
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public int delChatRoom(DelChatRoomInfo info, HttpServletRequest req) {
		dao= st.getMapper(ChatDao.class);
		//1.채팅방 삭제하기 전에 사진을 다 지워주기
		//	삭제할 채팅방의 이미지가 저장된 폴더명 --> ("room"+ 채팅방index)
		String uri ="/resources/image/room"+info.getRoomIdx();
		String folderPath = req.getSession().getServletContext().getRealPath(uri);
		File folder = new File(folderPath);
		if(folder.exists()&&info.getDelUser()!=null) {
			File[]files = folder.listFiles();
			for(int i =0;i<files.length;i++) {
				files[i].delete();
			}
			folder.delete();
		}
		//상대가 삭제한 채팅이면 바로삭제
		//아니면 삭제한 유저컬럼에 내이름을 올림
		if(info.getDelUser()!=null&&info.getDelUser().length()>0) {
			System.out.println("ChatRoomDelService>>삭제됨");
			dao.delChatRoom(info);
			return 1;
		}else {
			System.out.println("ChatRoomDelService>>삭제목록에 올라감");
			dao.updateRoomDate(info.getRoomIdx());
			dao.updateDelUser(info);
			return 0;
		}
	}

}
