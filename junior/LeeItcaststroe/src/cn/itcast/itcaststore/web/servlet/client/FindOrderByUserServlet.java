package cn.itcast.itcaststore.web.servlet.client;

/**
 * 根据用户查找订单
 */

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findOrderByUserServlet")
public class FindOrderByUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取名为User的session
        User user = (User)request.getSession().getAttribute("user");
        //2.调用service方法，根据用户信息查找订单
        OrderService service = new OrderService();
        List<Order> orders = service.findOrderByUser(user);
        request.setAttribute("orders", orders);
        //3.跳转到orderlist.jsp页面
        request.getRequestDispatcher("/client/orderlist.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
