package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 购物车商品数量的修改
 */

@WebServlet("/changeCartServlet")
public class ChangeCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到商品的id
        String id = request.getParameter("id");
        //2.得到要修改的数量
        int count = Integer.parseInt(request.getParameter("count"));
        //3.从session中获得购物车
        HttpSession session = request.getSession();
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        Product product = new Product();
        product.setId(id);
        if(count != 0){
            cart.put(product, count);
        }else{
            cart.remove(product);
        }
        //4.转向到cart.jsp页面
        response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
