import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示用户上次访问的时间，使用Cookie技术实现
 * @author 27289
 *
 */

public class LastAccessServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//0.设置编码，防止乱码
		response.setContentType("text/html;charset=utf-8");
		String lastAccessTime = null;
		
		//1.获取本地所有的Cookie 把他们存放到数组中
		
		Cookie[] cookies = request.getCookies();
		//遍历Cookie数组
		for(int i = 0; cookies != null && i < cookies.length; i++){
			if("lastAccess".equals(cookies[i].getName())){
				//如果Cookie的名称为lassAccess，则获取Cookie的值
				 lastAccessTime = cookies[i].getValue();
				 break;
			}
		}
		
		//2.判断是否存在名称为lassAccess 的Cookie 如果不存再说明第一次访问，否则 获得上次访问的时间
		if(lastAccessTime == null){
			response.getWriter().print("你是首次访问本网站！");
		}else{
			response.getWriter().print("您上次访问的时间是：" + lastAccessTime);
		}
		//3.把当前时间作为Cookie值发送到客户端
		String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		//创建一个Cookie
		Cookie cookie = new Cookie("lastAccess", currentTime);
		//发送Cookie
		response.addCookie(cookie);
		
	}
}
