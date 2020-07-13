package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class SimpleController extends HttpServlet{

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
		String type = req.getParameter("type");
		System.out.println("요청파악 : "+type);
		
		// 3. 핵심처리 : 기능수행
		Object resultObj = null;
		String page = "/simple_view.jsp";
		
		if(type==null||type.equals("greeting")) {
			resultObj = "하이염";
			page = "view01.jsp";
		}else if(type.equals("date")) {
			resultObj = new Date();
			page = "view02.jsp";
		}else {
			resultObj = "Invalid Type";
		}
		System.out.println("핵심처리 결과 : "+resultObj);
		System.out.println("속성에 저장");
		//4. 결과 데이터를 속성에 저장 : view페이지에 공유(전달)
		req.setAttribute("result", resultObj);
		
		//5. 포워딩
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}
	
}
