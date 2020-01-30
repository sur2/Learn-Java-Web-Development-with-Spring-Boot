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
 * Servlet implementation class DefaultSessionServlet
 */
@WebServlet("/session")
public class DefaultSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultSessionServlet() {
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
		out.println("<h3>세션 정보</h3>");
		HttpSession session = request.getSession();
		out.println("SessionID::"+session.getId()+"<br/>");
		out.println("Session Created::"+session.getCreationTime()+"<br/>");
		out.println("Session LastAccessTime::"+session.getLastAccessedTime()+"<br/>");
		out.println("</body>");
		out.println("</html>");
	}
}
