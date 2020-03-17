package cn.itcast.jdbc.demo;

import cn.itcast.jdbc.example.User;

import java.sql.SQLException;
import java.util.Date;

public class DBUtilsDaoTest1 {
    private static DBUtilsDdao dao = new DBUtilsDdao();
    public static void testInsert() throws SQLException{
        User user = new User();
        user.setuName("王五");
        user.setuPassword("sdfghj");
        user.setuBirthday(new Date());
        user.setuAddress("中国山东济宁hhhh");
        user.setuBankId("234567dfghj890");
        boolean b = dao.insert(user);
        System.out.println(b);
    }

    public static void main(String[] args) {
        try {
            testInsert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
