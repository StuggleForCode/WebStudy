import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestForwardServlet  extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html;charset=utf-8");
		//1.存储数据到request对象中
		
		request.setAttribute("company", "IMUSTSE17");
		//2.请求转发到第二个额Servlet(resultSevelet)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resultServlet");
		dispatcher.forward(request, response);
	}
}
