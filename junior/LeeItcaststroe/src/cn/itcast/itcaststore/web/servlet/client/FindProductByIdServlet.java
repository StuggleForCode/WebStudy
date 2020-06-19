package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据商品ID查找指定商品信息
 */

@WebServlet("/findProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到商品ID
        String id = request.getParameter("id");
        //2.获得type类型，用来判断是否是超级用户或者是普通用户，普通用户type为null
        String type = request.getParameter("type");
//        System.out.println(id);
//        System.out.println(type);
        //3.调用service层方法，通过id查找闪频
        try {
            ProductService service = new ProductService();
            Product product = service.findProductById(id);
//            System.out.println(product.getName());
            request.setAttribute("p", product);
            //4.普通用户跳转到商品信息详情页面，超级用户跳转到编辑页面
            if(type == null){
                request.getRequestDispatcher("/client/info.jsp").forward(request,response);
                return;
            }
            request.getRequestDispatcher("/admin/products/edit.jsp").forward(request,response);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
