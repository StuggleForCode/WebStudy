package cn.itcast.itcaststore.dao;

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单数据库操作
 */
public class OrderDao {
    //1.查找用户所属订单
    public List<Order> findOrderByUser(final User user) throws SQLException {
        String sql = "select * from orders where user id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //使用匿名内部类
        return runner.query(sql, new ResultSetHandler<List<Order>>() {
            @Override
            public List<Order> handle(ResultSet resultSet) throws SQLException {
                List<Order> orders = new ArrayList<Order>();
                while(resultSet.next()){
                    Order order = new Order();
                    order.setId(resultSet.getString("id"));
                    order.setMoney(resultSet.getDouble("money"));
                    order.setOrderTime(resultSet.getDate("ordertime"));
                    order.setPayState(resultSet.getInt("paystate"));
                    order.setReceiverAddress(resultSet.getString("receiverAddress"));
                    order.setReceiverName(resultSet.getString("receiverName"));
                    order.setReceiverPhone(resultSet.getString("receiverPhone"));
                    order.setUser(user);
                    orders.add(order);
                }
                return orders;
            }
        }, user.getId());
    }
}

