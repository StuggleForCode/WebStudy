package imust.se17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试使用ServletContext实现Servlet对象共享数据
 * @author 27289
 *
 */

public class TestServlet04 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletContext context = this.getServletContext();
		//通过setAttribute方法设置属性值
		context.setAttribute("saveData", "save data in TextServlet04 !");
		
		//取出context对象保存的值
		String data = (String) context.getAttribute("saveData");
		PrintWriter out = response.getWriter(); 
		out.println("data = " + data);
	}
}
