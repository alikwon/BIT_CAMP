package com.aia.mvc.header;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {
	
	@RequestMapping("/header/getHeader")
	public String getHeader(
					//HTTP 요청 헤더값 가져오기
					@RequestHeader("referer")String referer,
					Model model
					) {
		
		System.out.println(referer);
		model.addAttribute("referer",referer);
		return "/header/getHeader";
	}
}
