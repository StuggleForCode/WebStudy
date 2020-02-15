import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试获取请求消息头信息的方法
 * @author 27289
 *
 */


public class RequestHeadersServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取请求消息中所有头字段
		Enumeration headerNames = request.getHeaderNames();
		//使用循环遍历所有的请求头,通过getHeader()方案发获取指定名称的头字段
		while(headerNames.hasMoreElements()){
			String headerName = (String)headerNames.nextElement();
			out.println(headerName + ":" + request.getHeader(headerName) + "<br/>");
		}
	}
}
