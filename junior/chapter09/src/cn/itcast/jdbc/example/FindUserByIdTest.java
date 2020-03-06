package cn.itcast.jdbc.example;

import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;
import cn.itcast.jdbc.service.impl.UserServiceImpl;

public class FindUserByIdTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = userService.find(1);
        System.out.println(user);
    }
}
