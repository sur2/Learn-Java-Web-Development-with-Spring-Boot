package main.java.info.thecodinglive.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReadSessionServlet
 */
@WebServlet("/readse")
public class ReadSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<head>");
		out.write("<title>세션 읽기</title>");
		out.write("</head>");
		out.write("<body>");
		HttpSession session = request.getSession();
		String sessionValue = (String) session.getAttribute("jpub");
		out.write("<h3>세션 읽기</h3><br/>");
		out.write("생성된 세션 값: "+sessionValue);
		out.write("<br/>");
		out.write("<a href='./deletese'>세션 삭제</a>");
		out.write("</body>");
		out.write("</html>");
	}

}
