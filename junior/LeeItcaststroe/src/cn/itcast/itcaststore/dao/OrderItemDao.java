package cn.itcast.itcaststore.dao;

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.OrderItem;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单项数据库操作类
 */

public class OrderItemDao {
    //1.添加订单项
    public void addOrderItem(Order order) throws SQLException {
        //1.生成sql语句
        String sql = "insert into orderItem values(?,?,?)";
        //2.创建QueryRunner
        QueryRunner runner = new QueryRunner();
        //3.批量添加订单项
        List<OrderItem> items = order.getOrderItemList();
        Object[][] params = new Object[items.size()][3];

        for(int i = 0; i < params.length; i++){
            params[i][0] = items.get(i).getOrder().getId();
            params[i][1] = items.get(i).getProduct().getId();
            params[i][2] = items.get(i).getBuyNum();
        }
        runner.batch(DataSourceUtils.getConnection(), sql, params);
    }

    //2.根据订单查找订单项，并将订单项中商品查找到
    public List<OrderItem> findOrderItemByOrder(final Order order) throws SQLException {
        String sql = "select * from orderItem, Products where products.id = orderItem.product_id and order_id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new ResultSetHandler<List<OrderItem>>() {
            @Override
            public List<OrderItem> handle(ResultSet resultSet) throws SQLException {
                List<OrderItem> items = new ArrayList<OrderItem>();
                while (resultSet.next()){
                    OrderItem item = new OrderItem();
                    item.setOrder(order);
                    item.setBuyNum(resultSet.getInt("buynum"));
                    Product p = new Product();
                    p.setCategory(resultSet.getString("category"));
                    p.setId(resultSet.getString("id"));
                    p.setDescription(resultSet.getString("description"));
                    p.setImgurl(resultSet.getString("imgurl"));
                    p.setName(resultSet.getString("name"));
                    p.setPnum(resultSet.getInt("pnum"));
                    p.setPrice(resultSet.getDouble("price"));
                    item.setProduct(p);
                    items.add(item);
                }
                return items;
            }
        }, order.getId());
    }

    //3.根据订单id删除订单项
    public void delOrderItems(String id) throws SQLException {
        String sql = "delete from orderItem where order_id = ?";
        QueryRunner runner = new QueryRunner();
        runner.update(DataSourceUtils.getConnection(), sql, id);
    }


    public static void main(String[] args) throws SQLException {
        OrderItemDao dao = new OrderItemDao();
//        Order order = new Order();
//        order.setId("123456");
//        OrderItem item1 = new OrderItem();
//        OrderItem item2 = new OrderItem();
//        item1.setOrder(order);
//        item2.setOrder(order);
//        Product p1 = new Product();
//        Product p2 = new Product();
//        p1.setId("abc");
//        p2.setId("def");
//        item1.setProduct(p1);
//        item2.setProduct(p2);
//        item1.setBuyNum(1);
//        item2.setBuyNum(2);
//        List<OrderItem> orderItems = new ArrayList<OrderItem>();
//        orderItems.add(item1);
//        orderItems.add(item2);
//        order.setOrderItemList(orderItems);
//        dao.addOrderItem(order);

//        Order order = new Order();
//        order.setId("c4b2bfff-1694-4e28-bcf8-fa7169bfc978");
//        List<OrderItem> orderItems = dao.findOrderItemByOrder(order);
//        for(int i = 0; i < orderItems.size(); i++){
//            System.out.println(orderItems.get(i).getProduct().getName());
//        }
        dao.delOrderItems("123456");
    }
}
