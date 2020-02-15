package example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 显示购物车的内容
 * @author 27289
 *
 */

public class CartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取session 对象，判断用户是否已经购买图书
		//如果没有购买，显示没有购买

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//变量cart引用用户的购物车
		List<Book> cart = null;
		//变量purFlag标记用户是否买过商品
		boolean purFlag = true;
		//获得用户的session
		HttpSession session = request.getSession(false); //参数false,如有会话在则返回，否则返回null，参数为true,如有会话则返回，否则新建一个会话
		//如果session为null, purFlag置为false
		if(session == null){
			purFlag = false;
		}
		else{
			//获得用户购物车
			cart = (List) session.getAttribute("cart");
			//如果用的购物车为null, purFlag 置为false;
			if(cart == null){
				purFlag = false;
			}
		}
		// 如果purFlag 为false, 表明用户没有购买图书，重定向到ListServlet页面
		if(!purFlag){
			out.write("对不起！您还没有购买任何商品");
		}else{
			out.write("您购买的图书有：<br/>");
			double price = 0;
			for (Book book: cart){
				out.write(book.getName() + "<br/>");
			}
		}
	}

}
