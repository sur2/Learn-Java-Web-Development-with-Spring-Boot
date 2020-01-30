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
 * Servlet implementation class CreateSessionValueServlet
 */
@WebServlet("/createse")
public class CreateSessionValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSessionValueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>세션</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>세션 생성</h3>");
		HttpSession session = request.getSession();
//		session.setAttribute(name, value);
		session.setAttribute("jpub", "book");
		out.println("<a href='./readse'>세션 읽기</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
