package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.exception.FindProductByIdException;
import cn.itcast.itcaststore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到商品id
        String id = request.getParameter("id");
        //2.调用service层方法，根据id查找商品
        try {
            ProductService service = new ProductService();
            Product p = service.findProductById(id);
            //3.将商品添加到购物车
            //3.1获得session对象
            HttpSession session = request.getSession();
            //3.2从session中取出购物车对象
            Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
            //3.3如果购物车为null, 说明没有商品存储在购物车中，则创建购物车
            if(cart == null){
                cart = new HashMap<Product, Integer>();
            }
            //3.4否则，则商品中添加商品
            Integer count = cart.put(p, 1);//如果map中不存在改key,map的put()返回值为null;
                                            // 如果map中存在改key,map的put()返回值为旧的value;
            //3.5如果商品数量部位空，说明已将添加商品，则商品数量为1
           if(count != null){
               cart.put(p, count + 1);
           }
            //4.转向显示购物车页面
            session.setAttribute("cart", cart);
            response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
        } catch (FindProductByIdException e) {
            e.printStackTrace();
        }
        //3.将商品添加到购物车
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
