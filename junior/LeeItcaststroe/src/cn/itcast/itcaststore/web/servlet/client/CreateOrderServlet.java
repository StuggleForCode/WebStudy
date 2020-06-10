package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.OrderItem;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.OrderService;
import cn.itcast.itcaststore.utils.IdUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/createOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到当前用户
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        //2.从购物车中获取商品
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        //3.将数据封装到订单对象中
        Order order = new Order();
        try {
            BeanUtils.populate(order, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        order.setReceiverAddress(request.getParameter("receiverAddress"));
        order.setReceiverPhone(request.getParameter("receiverPhone"));
        order.setReceiverName(request.getParameter("receiverName"));
        order.setMoney(Double.valueOf(request.getParameter("money")));
        System.out.println(order.getReceiverName());
        System.out.println(order.getReceiverPhone());
        System.out.println(order.getReceiverAddress());
        System.out.println(order.getMoney());
        order.setId(IdUtils.getUUID());//封装订单id
        order.setUser(user);//封装装用户信息到订单
        for(Product p:cart.keySet()){
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setBuyNum(cart.get(p));
            item.setProduct(p);
            order.getOrderItemList().add(item);
        }
//        4.调用service中添加订单操作
        OrderService service = new OrderService();
        service.addOrder(order);
        response.sendRedirect(request.getContextPath()+"/client/createOrderSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
