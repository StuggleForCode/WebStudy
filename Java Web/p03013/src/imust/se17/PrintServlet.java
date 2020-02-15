package imust.se17;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试response对象获取字节输出流对象
 * @author 27289
 *
 */

public class PrintServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrintServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setCharacterEncoding("utf-8");
		//OutputStream out = response.getOutputStream();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String data = "中国";
		//out.write(data.getBytes());
		out.write(data);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
