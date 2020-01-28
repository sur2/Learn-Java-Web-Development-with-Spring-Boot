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
 * Servlet implementation class CookieDeleteServlet
 */
@WebServlet("/delcookie")
public class CookieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>쿠키 삭제</title>");
		out.print("</head>");
		out.print("<body>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("jpub")) {
					Cookie deleteCookie = new Cookie("jpub", null);
					deleteCookie.setMaxAge(0);
					response.addCookie(deleteCookie);
				}
			}
		}
		out.print("<a href='./readcookie'>쿠키 읽기</a>");
		out.print("</body>");
		out.print("</html>");
	}

}
