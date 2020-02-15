package example02;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//0.设置编码，防止乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取保存用户信息的session对象
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//2.判断用户是否登陆，如果登陆，显示欢迎信息，否则显示未登陆信息
		
		if(user == null){
			response.getWriter().println("您还没有登陆，请<a href ='/p05012/login.html' >登陆</a>");
		}else{
			response.getWriter().println("您已登录，欢迎您，" + user.getUsername() + "!");
			response.getWriter().println("<a href = '/p05012/logoutServlet'>退出</a>");
		}
		
		//3.创建cookie存放session的标识号
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/p05012");
		response.addCookie(cookie);
	}
}
