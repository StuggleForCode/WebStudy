package cn.itcast.itcaststore.dao;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class UserDao {
    //添加用户
    public void addUser(User user){
        String sql = "insert into user() values(username, password, gender, email, telephone, introduce, activeCode)" +
                " values(?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            int row = runner.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail()
            , user.getTelephone(), user.getIntroduce(), user.getActiveCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据激活码查找用户
    public User findUserByActiveCode(String activeCode){
        String sql = "select * from user where activeCode=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql, new BeanHandler<User>(User.class),activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //激活用户
    public void activeUser(String activeCode){
        String sql = "update user set state  = ? where activeCode = ? ";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            runner.update(sql, 1, activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据用户名和密码查找用户
    public User findUserByUsernameAndPassword(String userName, String password){
        String sql = "Select * from user where userName = ? and password = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql, new BeanHandler<User>(User.class), userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        UserDao ud = new UserDao();
        User user = new User();
//        user.setUsername("Tom");
//        ud.addUser(user);
//        user = ud.findUserByActiveCode("c1cc1229-f0ac-41b4-920c-dfef9f8a96a3");
//        System.out.println("name = " + user.getUsername());
//        ud.activeUser("c1cc1229-f0ac-41b4-920c-dfef9f8a96a3");
        user = ud.findUserByUsernameAndPassword("admin", "123456");
        System.out.println("id = " + user.getId());
    }
}

