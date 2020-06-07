package cn.itcast.itcaststore.service;

import cn.itcast.itcaststore.dao.UserDao;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.utils.MailUtils;

import javax.mail.MessagingException;
import java.util.Date;

public class UserService {
    private UserDao dao = new UserDao();
    //注册
    public void register(User user){
        //1.添加用户
        dao.addUser(user);
        //2.发送激活邮件
        String emailMsg = "感谢注册书城，单击" +
                "<a href='http://localhost:8080/itcaststore/activeUser?activeCode=" + user.getActiveCode() +
                "'>激活</a>后使用";
        try {
            MailUtils.sendMail(user.getEmail(), emailMsg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 激活用户
     * @param activeCode
     */
    public void activeUser(String activeCode){
        //1.根据激活码找到用户
        User user = dao.findUserByActiveCode(activeCode);
        if(user == null){
//            throw new ActiveUserException()
        }
        //2.判断是否过期24小时有效
        Date registerTime = user.getRegisterTime();
        long time = System.currentTimeMillis()-registerTime.getTime();
        if(time/1000/60/60>24){
//            throw new ActiveUserException("激活码过期");
        }
        //3.激活用户，修改用户的state 状态0改为1
        dao.activeUser(activeCode);
    }

    public static void main(String[] args) {
        UserService us = new UserService();
        User user = new User();
//        user.setUsername("student1");
//        user.setEmail("859316354@qq.com");
//        us.register(user);
        us.activeUser("c1cc1229-f0ac-41b4-920c-dfef9f8a96a3");
    }
}
