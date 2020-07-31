package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	//서블릿을 상속하지 않아도됨 --> 컨트롤러 어노테이션
	
	//사용자의 URL 등록
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		//model.addAllAttributes(attributes);
		// 올어트리뷰트는 Map으로 보통 등록함
		model.addAttribute("msg", "하이염");
		
		//반환해야할것 : /WEB-INF/views/hello/hello.jsp
		// ==> prefix + 리턴값 + suffix
		return "hello/hello";
		
	}
}
