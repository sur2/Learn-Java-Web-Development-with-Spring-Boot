package main.java.info.thecodinglive.pattern;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	
	abstract public void execute();
	
	public Command() {
		// TODO Auto-generated constructor stub
		System.out.println("초기화");
	}
	
	public void forward(String url) {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		try {
			rd.forward(getRequest(), getResponse());
		} catch (ServletException e) {
			e.printStackTrace();
			servletContext.log("forward Error", e);
		} catch (IOException e) {
			e.printStackTrace();
			servletContext.log("servlet Error", e);
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
