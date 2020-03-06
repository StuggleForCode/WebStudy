package cn.itcast.jdbc.example;

import cn.itcast.jdbc.service.UserService;
import cn.itcast.jdbc.service.impl.UserServiceImpl;

public class DeleteUserByIdTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        boolean bool = userService.del(3);
        System.out.println(bool);
    }
}
