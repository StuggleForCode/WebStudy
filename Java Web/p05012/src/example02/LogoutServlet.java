package example02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//0.设置编码，防止乱码
		response.setContentType("text/html;charset=utf-8");
		
		//1.将session对象中的User对象删除
		request.getSession().removeAttribute("user");
		//2.转向首页界面
		response.sendRedirect("/p05012/indexServlet");
		
		
	}
}
