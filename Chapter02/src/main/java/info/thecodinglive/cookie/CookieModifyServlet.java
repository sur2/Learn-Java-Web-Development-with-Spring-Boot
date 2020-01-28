package main.java.info.thecodinglive.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieModifyServlet
 * 쿠키값을 변경하려면 같은 이름으로 쿠키를 생성해서 새로운 값을 지정하면 된다.
 */
@WebServlet(urlPatterns = "/modicookie")
public class CookieModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieModifyServlet() {
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
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>쿠키 수정</title>");
		writer.print("<body>");
		String value = URLEncoder.encode("수정된 쿠키", "UTF-8");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("jpub")) {
					Cookie modifiedCookie = new Cookie("jpub", value);
					response.addCookie(modifiedCookie);
				}
			}
		}
		writer.print("<a href = './readcookie'>쿠키 읽으러 가기</a>");
		writer.print("</body>");
		writer.print("</head>");
		writer.print("</html>");
	}
}
