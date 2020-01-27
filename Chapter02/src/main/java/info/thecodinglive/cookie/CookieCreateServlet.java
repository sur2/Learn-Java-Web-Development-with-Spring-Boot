package main.java.info.thecodinglive.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCreateServlet
 */
@WebServlet(urlPatterns = "/newcookie")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>쿠키 예제</title>");
		writer.println("</head>");
		writer.println("<body>");
		
		Cookie jcookie = new Cookie("jpub", "books");// name, value
		// 쿠키 만료시간 : 1시간(60 * 60)
		jcookie.setMaxAge(3600);
		response.addCookie(jcookie);
		// 특정 사이트에서만 사용 가능한 쿠키를 만들 시 도메인을 지정
		// new Cookie(name, value).setDomain("도메인");
		writer.println("<a href='/readcookie'>쿠키 읽기</a>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
