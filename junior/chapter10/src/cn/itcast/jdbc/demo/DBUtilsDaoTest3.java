package cn.itcast.jdbc.demo;

import cn.itcast.jdbc.example.User;

import java.sql.SQLException;

public class DBUtilsDaoTest3 {
    private static DBUtilsDdao dao = new DBUtilsDdao();
    public static void testdelete() throws SQLException {
        boolean b = dao.delete(4);
        System.out.println(b);
    }

    public static void main(String[] args) {
        try {
            testdelete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
