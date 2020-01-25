package main.java.info.thecodinglive.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "uploadServlet", urlPatterns = "/upload")

// 바이너리 데이터 전송을 위한 어노테이션 
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 2, // 2mb
			maxFileSize = 1024 * 1024 * 10, // 10mb
			maxRequestSize = 1024* 1024 * 50, // 50mb
			// 파일위치
			location = "C:/Users/Owner/Desktop/coding/Learn-Java-Web-Development-with-Spring-Boot/Chapter02/assets/upload"
//			location = "c:/upload"
		)

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		// 경로
		final String path = request.getParameter("destination");
		// 파일
		final Part filePart = request.getPart("file");
		// 파일이름
		final String fileName = getFileName(filePart);
				
		PrintWriter writer = response.getWriter();
		
		try {
			OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
			InputStream filecontent = filePart.getInputStream();
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			writer.print("new File: " + fileName + "<br/>" + path + "에 생성되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	
	}
	
	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("Part Header = {0}" + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				System.out.println("content: " + content);
				return content.substring(content.indexOf('=') + 1).trim().replace("\"","");
			}
		}
		return null;
	}

}
