package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ByeController {
	
	@RequestMapping("/bye")
	public ModelAndView bye() {
		ModelAndView mav = new ModelAndView();
		
		//뷰에 공유할 데이터 설정
		mav.addObject("msg", "담에봐염 ㅋㅋ");
		
		//뷰의 이름 set
		mav.setViewName("hello/bye"); 
		// /WEB-INF/views/hello/bye.jsp
				
		return mav;
	}
}
