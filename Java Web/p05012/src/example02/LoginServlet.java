package example02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//0.设置编码，防止乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		//2.判断用户名和密码是否正确，如果正确转入首页界面，否则输出用户名密码错误的信息.假设正确的用户名和密码是:imust 123
		if("imust".equals(username) && ("123").equals(password)){
			//新建用户对象，把用户对象存入session
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user",user);
			//转向首页面
			response.sendRedirect("/p05012/indexServlet");
		}else{
			pw.write("用户名或密码错误登陆失败！");
		}
		
	}
}
