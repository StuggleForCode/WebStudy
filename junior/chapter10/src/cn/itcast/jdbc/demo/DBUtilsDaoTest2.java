package cn.itcast.jdbc.demo;

import cn.itcast.jdbc.example.User;

import java.sql.SQLException;

public class DBUtilsDaoTest2 {
    private static DBUtilsDdao dao = new DBUtilsDdao();
    public static void testupdate() throws SQLException {
        User user = new User();
        user.setuName("zhaoliu");
        user.setuPassword("1234567890");
        user.setuId(4);
        boolean b = dao.update(user);
        System.out.println(b);
    }

    public static void main(String[] args) {
        try {
            testupdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
