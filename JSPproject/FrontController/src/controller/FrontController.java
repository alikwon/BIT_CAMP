package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GreetingServiceImpl;
import service.Service;

@WebServlet
public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);		
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//2. 사용자 요청파악
//		req.getParameter(name)
//		req.getRequestURL()
//		req.getRequestURI() ★★★★★
//		localhost:8080/fc/simple --> URL
//		/fc/simple --> URI
		String type = null;
		String command = req.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(req.getContextPath()));
		if(command.indexOf(req.getContextPath())== 0) { //ContextPate의 인덱스 시작이 0이면
			//시작인덱스 이후를 뽑아냄 --> contextpate 이후의 스트링을 뽑아냄
			type = command.substring(req.getContextPath().length()); 
			
		}
		System.out.println("요청파악 : "+type);
		Service service = null;
		// 3. 핵심처리 : 기능수행
//		Object resultObj = null;
//		String page = "/WEB-INF/views/simple_view.jsp";
		
		//http://localhost:8080/fc/greeting
		//http://localhost:8080/fc/date		
		if(type==null||type.equals("/greeting")) {
//			resultObj = "하이염";
//			page = "/WEB-INF/views/view01.jsp";
			service = new GreetingServiceImpl();
		}else if(type.equals("/date")) {
//			resultObj = new Date();
//			page = "/WEB-INF/views/view02.jsp";
		}else if(type.equals("/")) {
//			resultObj = new Date();
//			page = "/WEB-INF/views/index.jsp";
		}else {
//			resultObj = "Invalid Type";
		}
//		System.out.println("핵심처리 결과 : "+resultObj);
//		System.out.println("속성에 저장");
		//4. 결과 데이터를 속성에 저장 : view페이지에 공유(전달)
//		req.setAttribute("result", resultObj);
		String page = service.getViewPage(req, resp);
		//5. 포워딩
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}
	
}
