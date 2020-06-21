package cn.itcast.itcaststore.web.servlet.client;

/**
 * 通过id查找订单
 */

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findOrderByIdServlet")
public class FindOrderByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户类型
        String type = request.getParameter("type");
        //2.得到要查询的订单id
        String id = request.getParameter("id");
        //3.根据id查找订单
        OrderService service = new OrderService();
        Order order = service.findOrderById(id);
        //4.将查询出的订单信息存储到request中
        request.setAttribute("order", order);
        //5.如果用户类型不为null，则转发到view.jsp页面，否则转发到orderinfo.jsp页面
        if(type != null){
            request.getRequestDispatcher("/admin/order/view.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/client/orderInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}