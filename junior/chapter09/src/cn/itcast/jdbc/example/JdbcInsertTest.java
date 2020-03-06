package cn.itcast.jdbc.example;

import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;
import cn.itcast.jdbc.service.impl.UserServiceImpl;

import java.util.Date;

public class JdbcInsertTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setuId(3);
        user.setuName("wangwu");
        user.setuPassword("12345678");
        user.setuBirthday(new Date());
        user.setuAddress("中国山东济宁");
        user.setuBankId("234567890");
        boolean b = userService.insertUser(user);
        System.out.println(b);
    }
}
