package imust.se17;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 实现网页的定时刷新并跳转
 * @author 27289
 *
 */

public class RefreshServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
		
		//response.setHeader("Refresh", "2;URL=http://www.imust.cn");
		//每隔三秒定时刷新当前页面
		response.setHeader("Refresh", "3");
		//输出当前事件
		response.getWriter().println(new Date());
		
	}
}
