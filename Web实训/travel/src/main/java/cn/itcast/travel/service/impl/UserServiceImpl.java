package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public ResultInfo regist(User user) {
        //1.判断用户名是否存在
        boolean flag = userDao.findByUsername(user.getUsername());
        System.out.println(flag);
        ResultInfo info = new ResultInfo();
        if(flag){
            info.setFlag(false);
            info.setErrorMsg("用户名已经存在");
        }else{
            //2.注册用户
            userDao.regist(user);
            MailUtils.sendMail("82181843@qq.com","黑马旅游网欢迎您的到来，<a href='http://localhost:8080/user/acitve?code="+user.getCode()+"'>点击激活</a>","黑马程序员，激活邮件");
            info.setFlag(true);
        }
        return info;
    }

    @Override
    public boolean active(String code) {
        return userDao.active(code);
    }

    @Override
    public User login(User user) {
        User loginUser = userDao.login(user);
        return loginUser;
    }
}
