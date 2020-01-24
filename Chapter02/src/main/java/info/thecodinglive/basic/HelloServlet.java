package main.java.info.thecodinglive.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name = "HelloServlet", urlPatterns = { "/helloget" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("GET 요청 서블릿 초기화");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 메서드 호출");
		response.setCharacterEncoding("UTF-8");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		// contextType 정의
		response.setContentType("text/html");
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>Pyong java webservice</title>");
		writer.write("</head>");
		writer.write("<body> get 요청 예제입니다.. </body>");
		writer.write("</html>");
		writer.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("GET 요청 서블릿 종료");
	}

}
