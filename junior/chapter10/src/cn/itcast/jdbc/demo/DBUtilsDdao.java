package cn.itcast.jdbc.demo;

import cn.itcast.jdbc.example.User;
import cn.itcast.jdbc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DBUtilsDdao {
    //创建QueryRunner对象
    QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
    //查询所有集合,返回List集合
    public List findAll() throws SQLException {
        String sql = "select * from users";
        List list = (List)runner.query(sql, new BeanListHandler<>(User.class));
        return  list;
    }
    //查询单个，返回对象
    public User find(int id) throws SQLException {
        String sql = "select * from users where uid = ?";
        //调用方法
        User user = (User)runner.query(sql, new BeanHandler<>(User.class), new Object[]{id});
        return user;
    }
    //添加用户的操作
    public Boolean insert(User user) throws SQLException {
        String sql = "insert into users (Uid, Uname, Upassword, Ubirthday, Uaddress, UBankId) values (null, ?, ?, ?, ?, ?)";
        int num = runner.update(sql, new Object[] {user.getuName(), user.getuPassword(), user.getuBirthday(), user.getuAddress(),user.getuBankId()});
        if(num > 0){
            return true;
        }
        return false;
    }
    //修改用户操作
    public Boolean update(User user) throws SQLException {
        String sql = "update users set uname = ?, upassword = ? where uid = ?";
        int num = runner.update(sql, new Object[] {user.getuName(), user.getuPassword(), user.getuId()});
        if(num > 0) return true;
        return false;
    }

    //删除用户的操作
    public Boolean delete(int id) throws SQLException {
        String sql = "delete from users where uid = ?";
        int num = runner.update(sql, id);
        if(num > 0) return true;
        return false;
    }
}
