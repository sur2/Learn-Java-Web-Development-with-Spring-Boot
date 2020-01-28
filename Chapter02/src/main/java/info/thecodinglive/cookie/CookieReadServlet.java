package main.java.info.thecodinglive.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieReadServlet
 */
@WebServlet("/readcookie")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieReadServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>쿠키 읽기</title>");
		out.println("</head>");
		out.println("<body>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("jpub")) {
					out.print("cookie::" + cookie.getName() + ": " + 
							URLDecoder.decode(cookie.getValue(), "UTF-8"));
				}
			}
		}
		System.out.println("브라우저가 가지고 있는 현재 페이지의 쿠기::"+Arrays.toString(cookies));
		out.print("<br/>");
		out.println("<a href='./modicookie'>쿠키 수정하기</a>");
		out.println("<a href='./delcookie'>쿠키 삭제하기</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
