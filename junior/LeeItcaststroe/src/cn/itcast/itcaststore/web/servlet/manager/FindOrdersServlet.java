package cn.itcast.itcaststore.web.servlet.manager;

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 后台
 * 查找所有订单
 */

@WebServlet("/findOrdersServlet")
public class FindOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建service对象
        OrderService service = new OrderService();
        //2.调用service的findAllOrder()方法查询订单列表
        List<Order> orders = service.findAllOrder();
        //3.将查询到的订单信息添加到request作用域
        request.setAttribute("orders", orders);
        //4.跳转list.jsp页面
        request.getRequestDispatcher("/admin/orders/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
