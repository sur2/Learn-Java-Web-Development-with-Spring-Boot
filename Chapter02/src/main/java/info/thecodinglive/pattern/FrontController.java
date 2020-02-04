package main.java.info.thecodinglive.pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = "/controller", initParams = {
		@WebInitParam(name = "mapping", value = "/WebContent/WEB-INF/command.properties") })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Properties cmdMapping;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd"); 
		/*
		String cmdClass = (String) cmdMapping.get("cmd"); 
		System.out.println(cmdClass);
		*/
		Command command = null;
		try {
			// Reflection을 이용한 인스턴스 생성 'Class.forName.newInstance'
			command = (Command) Class.forName("main.java.info.thecodinglive.pattern."+cmd).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getServletContext().log("class not found", e);
		}
		command.setRequest(request);
		command.setResponse(response);
		command.setServletContext(getServletContext());
		command.execute();
	}

}
