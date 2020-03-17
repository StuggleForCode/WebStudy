package cn.itcast.jdbc.example;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class ResultSetTest3 {
    public static void testScalarHandler() throws SQLException {
        BaseDao baseDao = new BaseDao();
        String sql = "select * from users where uid = ?";
        Object arr = (Object) baseDao.query(sql ,new ScalarHandler<>("Uname"), 1);
        System.out.println(arr);
    }

    public static void main(String[] args) {
        try {
            testScalarHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
