package cn.itcast.itcaststore.service;

import cn.itcast.itcaststore.dao.UserDao;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.exception.ActiveUserException;
import cn.itcast.itcaststore.utils.MailUtils;

import javax.mail.MessagingException;
import javax.security.auth.login.LoginException;
import java.util.Date;

public class UserService {
    private UserDao dao = new UserDao();
    //注册
    public void register(User user){
        //1.添加用户
        dao.addUser(user);
        //2.发送激活邮件
        String emailMsg = "感谢注册书城，单击" +
                "<a href='http://localhost:8080/LeeItcaststroe/activeUserServlet?activeCode=" + user.getActiveCode() +
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
    public void activeUser(String activeCode) throws ActiveUserException {
        //1.根据激活码找到用户
        User user = dao.findUserByActiveCode(activeCode);
        if(user == null){
            throw new ActiveUserException();
        }
        //2.判断是否过期24小时有效
        Date registerTime = user.getRegisterTime();
        long time = System.currentTimeMillis()-registerTime.getTime();
        if(time/1000/60/60>24){
            throw new ActiveUserException("激活码过期");
        }
        //3.激活用户，修改用户的state 状态0改为1
        dao.activeUser(activeCode);
    }


    //登陆
    public User login(String username, String password) throws LoginException {
        //1.根据用户名和密码查找用户
        try {
            User user = dao.findUserByUsernameAndPassword(username, password);
            //2.是否激活
            if(user != null){
                if(user.getState() == 1){//state=1说明已经激活
                    return user;
                }
                throw new LoginException("用户未激活");
            }
            throw new LoginException("用户名或密码错误!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new LoginException("登陆异常");
        }
    }


//    public static void main(String[] args) {
//        UserService us = new UserService();
//        User user = new User();
//        user.setUsername("student1");
//        user.setPassword("1234567");
//        user.setGender("男");
//        user.setEmail("leehao99@163.com");
//        user.setTelephone("15847249199");
//        user.setIntroduce("我是一名学生");
//        user.setState(0);
//        user.setActiveCode("1234567890fghjkghjkhjk");
////        user.setRegisterTime();
//        us.register(user);
////        us.activeUser("c1cc1229-f0ac-41b4-920c-dfef9f8a96a3");
//    }
}
