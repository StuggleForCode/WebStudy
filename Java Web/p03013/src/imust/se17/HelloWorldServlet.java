package imust.se17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HelloWorldServlet extends GenericServlet{
	public void service(ServletRequest request, ServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		//获得ServletConfig对象
		//ServletConfig config = this.getServletConfig();
		//获得参数名为encoding的对应的参数值
		//String param = config.getInitParameter("encoding");
		
		//out.print("encoding = " + param);
		
		//得到ServletContext对象
		ServletContext context = this.getServletContext();
		//得到包含所有初始化参数名的Enumeration对象
		Enumeration<String> paramNames = context.getInitParameterNames();
		out.println("all the paramName and paramValue are following:");
		//遍历所有的初始化参数名，得到相应的参数值并打印
		while(paramNames.hasMoreElements()){
			String name = paramNames.nextElement();
			String value = context.getInitParameter(name);
			out.println(name + ":" + value);
		}
	}
}
