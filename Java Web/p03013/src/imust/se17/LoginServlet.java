package imust.se17;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登陆Servlet
 * @author 27289
 *
 */

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
		//防止中文乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.判断用户名和密码是否正确，如果正确，跳到欢迎页面，否则，跳到登陆页面重新登陆
		if("imust".equals(username) && "123".equals(password)){
			response.sendRedirect("welcome.html");
		}else{
			response.sendRedirect("login.html");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
		doGet(request, response);
	}
	
}		
