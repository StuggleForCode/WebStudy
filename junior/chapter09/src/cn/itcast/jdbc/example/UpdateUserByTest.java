//package cn.itcast.jdbc.example;
//
//import cn.itcast.jdbc.Dao.UsersDao;
//import cn.itcast.jdbc.domain.User;
//import cn.itcast.jdbc.service.UserService;
//import cn.itcast.jdbc.service.impl.UserServiceImpl;
//
//import java.util.Date;
//
//public class UpdateUserByTest {
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        User user = new User();
//        user.setuId(3);
//        user.setuName("王五");
//        user.setuPassword("sdfghj");
//        user.setuBirthday(new Date());
//        user.setuAddress("中国山东济宁hhhh");
//        user.setuBankId("234567dfghj890");
//        boolean b = userService.update(user);
//        System.out.println(b);
//    }
//}
