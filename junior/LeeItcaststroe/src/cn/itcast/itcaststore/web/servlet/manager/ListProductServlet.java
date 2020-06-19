package cn.itcast.itcaststore.web.servlet.manager;

/**
 * 后台查询所有的商品
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

@WebServlet("/listProductServlet")
public class ListProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建service层对象
        ProductService service = new ProductService();
        //2.调用service用于查询所有商品的方法
        List<Product> ps = service.listAll();
        //3.将查出的商品放入request
        request.setAttribute("ps", ps);;
        //4。重定向list.jsp页面
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
