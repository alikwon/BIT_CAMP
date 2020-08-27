package com.aia.mangch.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.RequestInfo;

@Service
public class ChatMsgService {

	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;

	public List<ChatMsgInfo> getMsgList(int idx, String nick, int page) {
		dao = st.getMapper(ChatDao.class);

		final int MSG_PER_PAGE = 10;
		int startRow = page * MSG_PER_PAGE;
		int totalMsgCnt = dao.selectMsgCount(idx);
		int totalPage = totalMsgCnt / MSG_PER_PAGE;
		if (totalMsgCnt == 0) {
			return null;
		} else if (totalPage < page) {
			return null;
		}
		dao.readMsg(nick, idx); // 읽음 체크
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("nick", nick);
		map.put("startRow", startRow);
		map.put("msgPerPage", MSG_PER_PAGE);
		return dao.selectMsgList(map);
	}


	public String getMemberImg(String nick) {
		dao = st.getMapper(ChatDao.class);
		String img = dao.selectMemberImg(nick);
		System.out.println(img);
		return img;
	}

	public RequestInfo getRequestInfo(int idx) {
		dao = st.getMapper(ChatDao.class);
		RequestInfo ri = null;
		if (idx != 0) {
			ri = dao.selectRequest(idx);
		} else {
			ri = new RequestInfo();
			ri.setReqLoc("(알 수없음)");
			ri.setReqTitle("(삭제된 게시물 입니다)");
			ri.setReqNick("(알 수 없음)");
		}
		return ri;
	}

	public int readMsg(int idx, String nick) {
		dao = st.getMapper(ChatDao.class);
		return dao.readMsg(nick, idx);
	}


	public int deleteMsg(int idx) {
		dao = st.getMapper(ChatDao.class);
		String str = "(삭제된 메세지입니다)";
		int chk = dao.isTextMsg(idx);
		if (chk == 0) {
			//사진일시 파일삭제 해줘야함
			dao.getMsgImgPath(idx);
		}
		return dao.delMessage(idx,str);
	}
}
