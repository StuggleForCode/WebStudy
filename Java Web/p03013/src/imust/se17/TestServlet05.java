package imust.se17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet05 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//获得TestServlet04中存在的ServletContext对象的值
		ServletContext context = this.getServletContext();
		
		String data = (String)context.getAttribute("saveData");
		PrintWriter out = response.getWriter();
		System.out.println(data);
		
		out.println("Now in TestServlet05, out = " + data);
	
	}
}
