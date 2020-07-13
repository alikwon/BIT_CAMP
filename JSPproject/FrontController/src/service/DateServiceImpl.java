package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse responce) {
		// viewpage
		String viewPage = "/WEB-INF/views/view02.jsp";
		
		//응답데이터 처리
		Date now = new Date();
		
		request.setAttribute("result", now);
		
		return viewPage;
	}

}
