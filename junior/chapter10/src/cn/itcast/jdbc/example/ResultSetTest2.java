package cn.itcast.jdbc.example;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetTest2 {
    public static void testBeanListHandler() throws SQLException {
        BaseDao baseDao = new BaseDao();
        String sql = "select * from users ";
        ArrayList<User> list = (ArrayList<User>)baseDao.query(sql, new BeanListHandler<>(User.class));
        for (int i = 0; i < list.size(); i++){
            System.out.println("第" + (i + 1) + "条数据的username值为：" + list.get(i).getuName());
        }
    }

    public static void main(String[] args) {
        try {
            testBeanListHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
