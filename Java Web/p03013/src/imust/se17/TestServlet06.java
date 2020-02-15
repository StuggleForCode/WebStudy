package imust.se17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 测试利用ServletContext对象读取资源文件
 * @author 27289
 *
 */
public class TestServlet06 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ServletContext context = this.getServletContext();
		//获取相对路径中的输入流对象
		//InputStream in = context.getResourceAsStream("/WEB-INF/classes/SE17.properties");
		
		//获取文件的绝对路径
		String path = context.getRealPath("/WEB-INF/classes/SE17.properties");
		
		FileInputStream in = new FileInputStream(path);
		
		
		Properties pros = new Properties();
		pros.load(in);
		PrintWriter out = response.getWriter();
		out.println("company =" + pros.getProperty("company"));
		out.println("address =" + pros.getProperty("address"));
	}
}
