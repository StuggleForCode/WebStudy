package cn.itcast.itcaststore.web.servlet.manager;

/**
 *
 */

import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProductByManyConditionServlet")
public class FindProductByManyConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单数据
        String id = request.getParameter("id");//商品id
        String name = request.getParameter("name");//商品名称
        String category = request.getParameter("category");//商品种类
        String minPrice = request.getParameter("minprice");//商品最小价格
        String maxPrice = request.getParameter("maxprice");//商品最大价格
        System.out.println();
        //2.创建ProductService对象
        ProductService service = new ProductService();
        //3.调用service对象用户多条件查询的方法
        List<Product> products = service.findProductByManyCondition(id, name, category, minPrice, maxPrice);
        //4.将查询结果放入request域中
        request.setAttribute("ps", products);
        //5.重定向到商品管理首页list.jsp
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
