package cn.itcast.jdbc.example;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ResultSetTest1 {
    public static void testBeanHandler() throws SQLException{
        BaseDao baseDao = new BaseDao();
        String sql = "select * from users where Uid = ?";
        User user = (User)baseDao.query(sql, new BeanHandler<>(User.class), 1);
        System.out.println("id为1的User对象的name值为：" + user.getuName());
    }

    public static void main(String[] args) {
        try {
            testBeanHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
