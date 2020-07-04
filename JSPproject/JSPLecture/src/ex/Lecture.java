package ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lecture
 */
@WebServlet("/lec")
public class Lecture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}

	// form 태그의 method속성이 get일경우 호출
	// 웹브라우저의 주소창을 이용하여 servlet을 요청한 경우
	// URL값으로 정보가 전송 되서 보안에 약함
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get()");
		// 응답방식 결정
		response.setContentType("text/html; charset = euc-kr");
		// 웹브라우저에 출력하기 위한 스트림
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>hello<h1>");
		out.println("</body>");
		out.println("</html>");
	}

	// header를 이용해서 정보가 전송되어서 보안에 강함.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post()");
		doGet(request, response);
	}

}
