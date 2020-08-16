package com.aia.socket.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aia.socket.domain.Message;
import com.aia.socket.domain.PushVo;
import com.aia.socket.domain.ResultVo;
import com.aia.socket.service.PushServiceImpl;

@Controller
public class ChattingController extends CommonController {

	public static Map<String,String> sessionList = new HashMap<String,String>();

	@Autowired
	private PushServiceImpl pushService;
	
	@RequestMapping("/chatting")
	public ModelAndView chat(
			ModelAndView mv,
			@RequestParam("uid") String uid,
			HttpSession session
			) {
		
		mv.setViewName("chat/chat");
		mv.addObject("user", uid);
		mv.addObject("articleId", "12345");
		mv.addObject("articleOwner", "jin");
		
		session.setAttribute("user", uid);
		
		return mv;
	}
	
	@RequestMapping(value="/chattingConnection", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResultVo> chattingConnection(Message message, HttpServletRequest request) {
		final ResultVo resultVo = new ResultVo(HttpStatus.OK);
    	System.out.println(StringUtils.isEmpty(sessionList.get(message.getUser())));
    	if ( StringUtils.isEmpty(sessionList.get(message.getUser())) ) {
			sessionList.put(message.getUser(),request.getSession().toString());
			PushVo pushVo = new PushVo();
			pushVo.setPayload(message.getUser()+" 접속 함");
			pushService.push(pushVo);
		}
		
    	return resultVo.build();
	}
	
	@RequestMapping(value="/broadMessage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResultVo> broadMessage(Message message, HttpServletRequest request) {
		final ResultVo resultVo = new ResultVo(HttpStatus.OK);
		PushVo pushVo = new PushVo();
		pushVo.setPayload(message.getMessage());
		pushService.push(pushVo);
		
    	return resultVo.build();
	}
	
}
