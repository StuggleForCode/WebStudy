package cn.itcast.chapter11.model2.util;

import cn.itcast.chapter11.model2.domain.UserBean;

import java.util.HashMap;

public class DBUtil {
    private static DBUtil instance = new DBUtil();
    //定义user集合，用于模拟数据库
    private HashMap<String, UserBean> users = new HashMap<String, UserBean>();

    public static DBUtil getInstance() {
        return instance;
    }

    public static void setInstance(DBUtil instance) {
        DBUtil.instance = instance;
    }

    private DBUtil(){
        //向数据库(users)中存入两条数据
        UserBean user1 = new UserBean();
        user1.setName("Jack");
        user1.setPassword("123456789");
        user1.setEmail("jack@it135.org");
        users.put("Jack", user1);
        UserBean user2 = new UserBean();
        user2.setName("Rose");
        user2.setPassword("asdfghjkl");
        user2.setEmail("rose@it315.org");
        users.put("Rose", user2);
    }
    //获取数据库users中的数据
    public UserBean getUser(String userName){
        UserBean user = (UserBean) users.get(userName);
        return user;
    }
    //想数据库users插入数据
    public boolean insertUser(UserBean user){
        if(user == null){
            return  false;
        }
        String userName = user.getName();
        if(users.get(userName) != null){
            return false;
        }
        users.put(userName, user);
        return true;
    }
}
