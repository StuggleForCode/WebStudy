package imust.se17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Servlet_mutil_map extends HttpServlet{
	public void service(ServletRequest request, ServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("this servlet is create by myeclipse!");
	}
}
