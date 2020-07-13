package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse responce) {
		// viewpage
		String viewPage = "/WEB-INF/views/null.jsp";
		
		return viewPage;
	}

}
