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
        String sql = "select * from orders where user_id = ?";
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

    //2.生成订单
    public void addProduct(Order order) throws SQLException {
        //生成sql语句
        String sql = "insert into orders values(?,?,?,?,?,0,null,?)";
        //生成执行sqL的QueryRunner
        QueryRunner runner = new QueryRunner();
        //执行update方法插入数据
        runner.update(DataSourceUtils.getConnection(), sql, order.getId(), order.getMoney(), order.getReceiverAddress(),
                order.getReceiverName(), order.getReceiverPhone(), order.getUser().getId());
    }

    //3.修改订单状态
    public void updateOrderSate(String id) throws SQLException {
        //paystate=0 未支付，payState=1 已支付
        String sql = "update orders set paystate = 1 where id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, id);
    }

    //4.根据id删除订单
    public void deleteOrderById(String id) throws SQLException {
        String sql = "delete from orders where id = ?";
        QueryRunner runner = new QueryRunner();
        runner.update(DataSourceUtils.getConnection(),sql, id);
    }

    //5.根据id查找订单信息
    public Order findOrderById(String id) throws SQLException {
        String sql = "select * from orders, user where orders.user_id = user.id and orders.id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new ResultSetHandler<Order>() {
            @Override
            public Order handle(ResultSet resultSet) throws SQLException {
                Order order = new Order();
                while (resultSet.next()){
                    order.setId(resultSet.getString("orders.id"));
                    order.setMoney(resultSet.getDouble("orders.money"));
                    order.setOrderTime(resultSet.getDate("orders.ordertime"));
                    order.setPayState(resultSet.getInt("orders.paystate"));
                    order.setReceiverAddress(resultSet.getString("orders.receiverAddress"));
                    order.setReceiverName(resultSet.getString("orders.receiverName"));
                    order.setReceiverPhone(resultSet.getString("orders.receiverPhone"));
                    User user = new User();
                    user.setId(resultSet.getInt("user.id"));
                    user.setEmail(resultSet.getString("user.email"));
                    user.setGender(resultSet.getString("user.gender"));
                    user.setActiveCode(resultSet.getString("user.activecode"));
                    user.setIntroduce(resultSet.getString("user.introduce"));
                    user.setPassword(resultSet.getString("user.password"));
                    user.setRegisterTime(resultSet.getDate("user.registertime"));
                    user.setRole(resultSet.getString("user.role"));
                    user.setState(resultSet.getInt("user.state"));
                    user.setTelephone(resultSet.getString("user.telephone"));
                    user.setUsername(resultSet.getString("user.username"));
                    order.setUser(user);
                }
                return order;
            }
        }, id);
    }

    //6.查找所有的订单
    public List<Order> findAllOrder() throws SQLException {
        String sql = "select orders.*, user.* from orders, user where user.id = orders.user_id order by orders.user_id";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        return runner.query(sql, new ResultSetHandler<List<Order>>() {
            @Override
            public List<Order> handle(ResultSet resultSet) throws SQLException {
                List<Order> orders = new ArrayList<Order>();
                //遍历用户和订单的信息
                while (resultSet.next()){
                    Order order = new Order();
                    order.setId(resultSet.getString("orders.id"));
                    order.setMoney(resultSet.getDouble("orders.money"));
                    order.setOrderTime(resultSet.getDate("orders.ordertime"));
                    order.setPayState(resultSet.getInt("orders.paystate"));
                    order.setReceiverAddress(resultSet.getString("orders.receiverAddress"));
                    order.setReceiverName(resultSet.getString("orders.receiverName"));
                    order.setReceiverPhone(resultSet.getString("orders.receiverPhone"));
                    User user = new User();
                    user.setId(resultSet.getInt("user.id"));
                    user.setEmail(resultSet.getString("user.email"));
                    user.setGender(resultSet.getString("user.gender"));
                    user.setActiveCode(resultSet.getString("user.activecode"));
                    user.setIntroduce(resultSet.getString("user.introduce"));
                    user.setPassword(resultSet.getString("user.password"));
                    user.setRegisterTime(resultSet.getDate("user.registertime"));
                    user.setRole(resultSet.getString("user.role"));
                    user.setState(resultSet.getInt("user.state"));
                    user.setTelephone(resultSet.getString("user.telephone"));
                    user.setUsername(resultSet.getString("user.username"));
                    order.setUser(user);
                    orders.add(order);
                }
                return orders;
            }
        });
    }

    //7.多条件查询
    public List<Order> findOrderByManyCondition(String id, String receiverName) throws SQLException {
        //1.创建集合对象
        List<Object> objs = new ArrayList<Object>(); //objs存放动态参数
        //2.定义查询sql
        String sql = "select orders.*, user.* from orders, user where user.id = orders.user_id";
        //3.根据参数动态拼接sql语句
        if(id != null && id.trim().length() > 0){
            sql += " and orders.id = ? ";
            objs.add(id);
        }
        if(receiverName != null && receiverName.trim().length() > 0){
            sql += " and receiverName = ? ";
            objs.add(receiverName);
        }
        sql += " order by orders.user_id";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //4.创建QueryRunner对象
        return runner.query(sql, new ResultSetHandler<List<Order>>() {
            @Override
            public List<Order> handle(ResultSet resultSet) throws SQLException {
                List<Order> orders = new ArrayList<Order>();
                //遍历用户和订单的信息
                while (resultSet.next()){
                    Order order = new Order();
                    order.setId(resultSet.getString("orders.id"));
                    order.setMoney(resultSet.getDouble("orders.money"));
                    order.setOrderTime(resultSet.getDate("orders.ordertime"));
                    order.setPayState(resultSet.getInt("orders.paystate"));
                    order.setReceiverAddress(resultSet.getString("orders.receiverAddress"));
                    order.setReceiverName(resultSet.getString("orders.receiverName"));
                    order.setReceiverPhone(resultSet.getString("orders.receiverPhone"));
                    User user = new User();
                    user.setId(resultSet.getInt("user.id"));
                    user.setEmail(resultSet.getString("user.email"));
                    user.setGender(resultSet.getString("user.gender"));
                    user.setActiveCode(resultSet.getString("user.activecode"));
                    user.setIntroduce(resultSet.getString("user.introduce"));
                    user.setPassword(resultSet.getString("user.password"));
                    user.setRegisterTime(resultSet.getDate("user.registertime"));
                    user.setRole(resultSet.getString("user.role"));
                    user.setState(resultSet.getInt("user.state"));
                    user.setTelephone(resultSet.getString("user.telephone"));
                    user.setUsername(resultSet.getString("user.username"));
                    order.setUser(user);
                    orders.add(order);
                }
                return orders;
            }
        }, objs.toArray());
        //5.返回query方法的执行结果
    }

    public static void main(String[] args) throws SQLException {
        OrderDao dao = new OrderDao();
        User user = new User();
        user.setId(4);
//        List<Order> orderByUser = dao.findOrderByUser(user);
//        for(int i = 0; i < orderByUser.size(); i++){
//            System.out.println(orderByUser.get(i).getId());
//        }
        /*Order order = new Order();
        order.setId("123");
        order.setMoney(50);
        order.setReceiverAddress("包头");
        order.setReceiverName("Tom");
        order.setReceiverPhone("11212");
        order.setUser(user);
        dao.addProduct(order);*/
//        dao.updateOrderSate("123");
//        dao.deleteOrderById("123");

//        Order order = dao.findOrderById("677a7314-0e16-4e18-8aec-552f848e0d75");
//        System.out.println(order.getId());
//        System.out.println(order.getReceiverAddress());
//        System.out.println(order.getUser().getUsername());

//        List<Order> orders = dao.findAllOrder();
//        for(int i = 0; i < orders.size(); i++){
//            System.out.println(orders.get(i).getId());
//            System.out.println(orders.get(i).getUser().getUsername());
//        }

        List<Order> orders = dao.findOrderByManyCondition("d88d75cd-15e3-4622-801d-4cad902aeaa1", "hanyongmeng");
        for(int i = 0; i < orders.size(); i++){
            System.out.println(orders.get(i).getId());
            System.out.println(orders.get(i).getUser().getUsername());
        }
    }

}


