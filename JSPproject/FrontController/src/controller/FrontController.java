package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DateServiceImpl;
import service.GreetingServiceImpl;
import service.IndexServiceImpl;
import service.NullServiceImpl;
import service.Service;

@WebServlet
public class FrontController extends HttpServlet{
	
	//사용자 요청경로 ==> 키값
	Map<String, Service> commands = new HashMap<String, Service>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//1. commandService.propertise(외부 설정) ==> Propertise
		//2. 클래스 정보의 클래스들을 생성 ==>인스턴스 생성
		//3. map에 사용자 요청 command와 인스턴스를 저장
		//4. /index = service.IndexServiceImpl
		
		
		//설정파일의 웹경로
		String path = "/WEB-INF/commandService.properties";
		
		//설정파일의 시스템절대경로
		String configFile = config.getServletContext().getRealPath(path);
		System.out.println("config : " +configFile);
		//1. 외부 설정파일의 내용을 메모리의 데이터로 이동
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(configFile);
			// property 객체로 파일을 읽어온당
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator itr = prop.keySet().iterator();
		
//		while(itr.hasNext()) {
//			//이터레이터로 키값을 줄세워서 가져옴
//			String command = (String) itr.next();
//			String serviceClassName = prop.getProperty(command);
//			System.out.println(command+"= "+ serviceClassName);
//		}
		
		while(itr.hasNext()) {
			//사용자 요청 URI
			String command = (String) itr.next(); 
			// 사용자 요청의 처리를 위한 클래스 이름, 정보
			String serviceClassName = prop.getProperty(command);
			try {
				//인스턴스 생성을 위한 클래스 객체 
				Class serviceClass = Class.forName(serviceClassName);
				
				//인스턴스 생성 >> 형변환 , 예외발생
				Service service = (Service) serviceClass.newInstance();
				
				commands.put(command, service);
				
				System.out.println(command+"= "+service);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
		
//		commands.put("/", new IndexServiceImpl());
//		commands.put("/index", new IndexServiceImpl());
//		commands.put("/greeting", new GreetingServiceImpl());
//		commands.put("/date", new DateServiceImpl());
//		commands.put("null", new NullServiceImpl());
	}

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
		System.out.println("command : "+command);
		if(command.indexOf(req.getContextPath())== 0) { //ContextPate의 인덱스 시작이 0이면
			//시작인덱스 이후를 뽑아냄 --> contextpate 이후의 스트링을 뽑아냄
			type = command.substring(req.getContextPath().length()); 
			
		}
		System.out.println("요청파악 : "+type);
		// 3. 핵심처리 : 기능수행
		Service service = commands.get(type);
		
		if(service == null) {
			service = new NullServiceImpl();
		}
//		Object resultObj = null;
//		String page = "/WEB-INF/views/simple_view.jsp";
		
		//http://localhost:8080/fc/greeting
		//http://localhost:8080/fc/date		
//		if(type.equals("/greeting")) {
////			resultObj = "하이염";
////			page = "/WEB-INF/views/view01.jsp";
//			service = new GreetingServiceImpl();
//		}else if(type.equals("/date")) {
////			resultObj = new Date();
////			page = "/WEB-INF/views/view02.jsp";
//			service = new DateServiceImpl();
//		}else if(type.equals("/")|| type.equals("/index")) {
////			resultObj = new Date();
////			page = "/WEB-INF/views/index.jsp";
//			service = new IndexServiceImpl();
//		}else {
////			resultObj = "Invalid Type";
//			service = new NullServiceImpl();			
//		}
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
