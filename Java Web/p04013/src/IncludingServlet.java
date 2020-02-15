import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IncludingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.请求包含第二个Servlet--includedServlet
		RequestDispatcher rd = request.getRequestDispatcher("/includedServlet?p1=abc");
		
		out.print("before including" + "<br/>");
		
		rd.include(request, response);
		
		//2.显示输出
		out.print("after including" + "<br/>");
		
	}
}
