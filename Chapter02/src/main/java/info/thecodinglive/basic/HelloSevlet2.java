package main.java.info.thecodinglive.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSevlet2
 */
@WebServlet(name = "HelloServlet2", urlPatterns = "/hellopost")
public class HelloSevlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloSevlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("POST 요청 서블릿 초기화");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("POST 요청 서블릿 종료");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 호출");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>POST 요청 처리</title>");
		writer.write("</head>");
		writer.write("<body>POST 요청을 처리할 수 없습니다.<body>");
		writer.write("</html>");
		writer.close();

		/*
		 * HTTP 상태 405 – 허용되지 않는 메소드 타입 상태 보고
		 * 
		 * 메시지 HTTP 메소드 GET은 이 URL에 의해 지원되지 않습니다.
		 * 
		 * 설명 요청 행에 포함된 해당 메소드는, origin 서버에 의해 인지되었으나, 대상 리소스에 의해 지원되지 않습니다.
		 * 
		 * Apache Tomcat/8.5.50
		 */
	}

}
