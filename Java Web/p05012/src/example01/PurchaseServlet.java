package example01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户点击购买把书加入购物车
 * @author 27289
 *
 */

public class PurchaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1.购买图书的信息保存到session对象中
		String id = request.getParameter("id");
		if(id == null){
			//如果id为null, 重定向到ListBookServlet页面
			String url = "listBookServlet";
			response.sendRedirect(url);
			return;
		}
		Book book = BookDB.getBook(id);
		//创建或者获得用户的Session对象
		HttpSession session =  request.getSession();
		//从Session对象中获得用户的购物车
		List<Book> cart = (List) session.getAttribute("cart");
		if(cart == null){//购物车为空，第一次访问
			//首次购买，为用户创建一个购物车（List集合模拟购物车）
			cart = new ArrayList<Book>();
			//将购物车存入Session对象
			session.setAttribute("cart", cart);
		}
		//将商品放入购物车
		cart.add(book);
		//创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/p05012");
		response.addCookie(cookie);
		//重定向到购物车页面
		String url = "cartServlet";
		response.sendRedirect(url);
	}
}
