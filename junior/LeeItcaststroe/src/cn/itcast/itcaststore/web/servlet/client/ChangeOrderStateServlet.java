package cn.itcast.itcaststore.web.servlet.client;
/**
 * 改变订单状态：由0到1 由未支付变为已支付
 */

import cn.itcast.itcaststore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeOrderStateServlet")
public class ChangeOrderStateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得订单号
        String orderid = request.getParameter("orderid");
        String paySuccess = "恭喜您支付成功";
        //2.根据订单号修改订单状态
        if(null != orderid){
            OrderService service = new OrderService();
            service.updateState(orderid);//改变订单状态：由0到1 由未支付变为已支付
            request.setAttribute("paySuccess", paySuccess);
            request.getRequestDispatcher("findOrderByUserServlet").forward(request,response);
        }
        //3.转向根据用户查找订单servlet
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
