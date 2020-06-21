//package cn.itcast.jdbc.example;
//
//import cn.itcast.jdbc.domain.User;
//import cn.itcast.jdbc.service.UserService;
//import cn.itcast.jdbc.service.impl.UserServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindAllUsersTest {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        List<User> list = userService.findAll();
//        for(User tmp : list){
//            System.out.println(tmp.getuId() + " " + tmp.getuName() + " " + tmp.getuPassword() + " " + tmp.getuBirthday()
//                    + " " + tmp.getuAddress() + " " + tmp.getuBankId());
//        }
//    }
//}
