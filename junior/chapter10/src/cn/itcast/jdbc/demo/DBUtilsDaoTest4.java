package cn.itcast.jdbc.demo;

import cn.itcast.jdbc.example.User;

import java.sql.SQLException;

public class DBUtilsDaoTest4 {
    private static DBUtilsDdao dao = new DBUtilsDdao();
    public static void testfind() throws SQLException {
        User user = dao.find(2);
        System.out.println(user);
    }

    public static void main(String[] args) {
        try {
            testfind();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
