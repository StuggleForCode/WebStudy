package example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 列出本站提供的所有图书
 * @author 27289
 *
 */

public class ListBookServlet extends HttpServlet {
	public static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//设置编码，防止乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//列出所有的图书
		Collection<Book> books = BookDB.getAll();
		out.write("本站提供的图书有：<br />");
		for(Book book : books){
			String url = "purchaseServlet?id=" + book.getId();
			out.write(book.getName() + "<a href = '" + url + "'>点击购买</a><br />");
		}
	}
}
