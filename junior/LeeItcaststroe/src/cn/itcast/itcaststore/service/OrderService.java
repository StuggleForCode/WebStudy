package cn.itcast.itcaststore.service;

import cn.itcast.itcaststore.dao.OrderDao;
import cn.itcast.itcaststore.dao.OrderItemDao;
import cn.itcast.itcaststore.dao.ProductDao;
import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.OrderItem;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单Service类
 */

public class OrderService {
    private OrderItemDao orderItemDao = new OrderItemDao();
    private OrderDao orderDao = new OrderDao();
    private ProductDao productDao = new ProductDao();

    //1.添加订单
    public void addOrder(Order order) {
        //1.开启事务
        try {
            DataSourceUtils.startTransaction();
            //2.完成操作
            //2.1向orders表中添加数据
            orderDao.addProduct(order);
            //2.2向orderItem表中添加数据
            orderItemDao.addOrderItem(order);
            //2.3修改表中的数据
            productDao.changeProductNum(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                DataSourceUtils.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            //3.关闭，释放以及提交事务
            try {
                DataSourceUtils.releaseAndCloseConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //2.删除订单
    public void delOrder(Order order) {
        //1.开启事务
        try {
            DataSourceUtils.startTransaction();
            //2.完成操作
            //2.1向orders表中添加数据
            orderDao.deleteOrderById(order.getId());
            //2.2向orderItem表中添加数据
            orderItemDao.delOrderItems(order.getId());
            //2.3修改表中的数据
            productDao.updateProductNum(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                DataSourceUtils.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            //3.关闭，释放以及提交事务
            try {
                DataSourceUtils.releaseAndCloseConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //3.根据用户查找订单的方法
    public List<Order> findOrderByUser(User user){
        List<Order> orders = null;
        try {
            orders = orderDao.findOrderByUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    //4.根据id查找订单
    public Order findOrderById(String id){
        Order order = null;
        try {
            order = orderDao.findOrderById(id);
            List<OrderItem> orderItems = orderItemDao.findOrderItemByOrder(order);
            order.setOrderItemList(orderItems);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    //5.支付后更新状态为1
    public void updateState(String id){
        try {
            orderDao.updateOrderSate(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        OrderService service = new OrderService();
//        Order order = new Order();
//        order.setId("123id");
//        OrderItem item1 = new OrderItem();
//        OrderItem item2 = new OrderItem();
//        item1.setOrder(order);
//        item2.setOrder(order);
//        Product product1 = new Product();
//        Product product2 = new Product();
//        product1.setId("abcd");
//        product2.setId("efgh");
//        item1.setBuyNum(2);
//        item2.setBuyNum(1);
//        item1.setProduct(product1);
//        item2.setProduct(product2);
//        User user = new User();
//        user.setId(3);
//        order.setUser(user);
//        List<OrderItem> orderItems = new ArrayList<OrderItem>();
//        orderItems.add(item1);
//        orderItems.add(item2);
//        order.setOrderItemList(orderItems);
//        service.addOrder(order);

//        Order order = new Order();
//        OrderDao orderDao = new OrderDao();
//        order = orderDao.findOrderById("d23a4e10-e21c-4399-b867-3dc89e7b30bc");
//        service.delOrder(order);

//        User user = new User();
//        user.setId(3);
//        List<Order> orders =  service.findOrderByUser(user);
//        for(Order order:orders){
//            System.out.println(order.getId());
//        }

//        Order order = service.findOrderById("677a7314-0e16-4e18-8aec-552f848e0d75");
//        List<OrderItem> items = order.getOrderItemList();
//        for(OrderItem item:items){
//            System.out.println(item.getProduct().getId());
//        }
        service.updateState("123id");

    }
}
