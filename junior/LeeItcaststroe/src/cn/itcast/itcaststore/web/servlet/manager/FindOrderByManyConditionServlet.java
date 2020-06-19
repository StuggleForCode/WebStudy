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
 * 按订单id, 收货人查询订单
 */
@WebServlet("/findOrderByManyConditionServlet")
public class FindOrderByManyConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = null;
        id = request.getParameter("id");
        String receiverName = request.getParameter("receiverName");
        System.out.println(id);
        System.out.println(receiverName);
        OrderService service = new OrderService();
        List<Order> orders = service.findOrderByManyCondition(id, receiverName);
        request.setAttribute("order", orders);
        request.getRequestDispatcher("/admin/orders/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
