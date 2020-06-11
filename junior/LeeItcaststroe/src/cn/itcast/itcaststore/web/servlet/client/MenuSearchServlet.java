package cn.itcast.itcaststore.web.servlet.client;
/**
 * 前台页面，用户菜单栏下面搜索功能的Servlet
 */

import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menuSearchServlet")
public class MenuSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.定义当前页面,默认为1
        int currentPage = 1;
        String _currentPage = request.getParameter("currentPage");
        if(_currentPage != null){
            currentPage = Integer.parseInt(_currentPage);
        }
        //2.定义每页条数，默认为4
        int currentCount = 4;
        //3.获取前台页面搜索框输入的值
        String searchfield=request.getParameter("textfield");
        //4.如果搜索框中没有输入值，则表单传递的默认值，此时默认值查询全部商品目录
        if("请输入书名".equals(searchfield)){
            request.getRequestDispatcher("/showProductByPageServlet").forward(request,response);
            return;
        }
        //5.调用service的方法，通过书名模糊查询到响应的图书
        ProductService service = new ProductService();
        PageBean bean = service.findBookByName(currentPage, currentCount, searchfield);
        //6.将数据存储到request范围，跳转到商品搜索页面列表
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/client/product_search_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
