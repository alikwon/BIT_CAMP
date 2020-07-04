package ex;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEx
 */
@WebServlet("/lifecycle")
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleEx() {
        super();
    }

    
    
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
	}
	/*
	@PostConstruct
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	private void destroyPreDestroy() {
		System.out.println("destroyPreDestroy");
	}
	*/
}
