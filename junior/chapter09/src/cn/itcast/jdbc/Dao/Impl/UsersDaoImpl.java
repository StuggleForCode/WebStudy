package cn.itcast.jdbc.Dao.Impl;

import cn.itcast.jdbc.Dao.UsersDao;
import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.utils.DataSourceUtils;
import com.mchange.v1.util.ArrayUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {

    @Override
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users(Uname, Upassword, Ubirthday, Uaddress, UBankId)" +
                "VALUES(" + "'" + user.getuName() + "','" + user.getuPassword() + "','" + user.getuBirthday()
                +"','" + user.getuAddress() + "','" + user.getuBankId() + "')";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql);
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "select * from users";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<User>(User.class));
    }

    @Override
    public User findById(int id) {
        String sql = "Select * from users where Uid = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void del(int id) {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "DELETE FROM users WHERE Uid = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users set Uname = '" + user.getuName() + "', Upassword= '" + user.getuPassword() + "', Ubirthday= '" + user.getuBirthday()
                +"', Uaddress= '" + user.getuAddress() + "',UBankId= '" + user.getuBankId() +"' " + "WHERE Uid = " + user.getuId();
        //System.out.println(sql);
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            runner.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> findUserByManyCondition(String uId, String uBankId, String uName) throws SQLException {
        List<Object> list = new ArrayList<Object>();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from users where 1 = 1 "; //1 = 1 永为真，构建动态sql
        if(uId != null && uId.trim().length()>0){
            sql += " and uId =  ?";
            list.add(uId);
        }
        if(uName != null && uName.trim().length()>0){
            sql += " and uName = ?";
            list.add(uName);
        }
        if(uBankId != null && uBankId.trim().length()>0){
            sql += "  and uBankId = ?";
            list.add(uBankId);
        }
        System.out.println(sql);
        Object[] params = list.toArray();
        return runner.query(sql, new BeanListHandler<>(User.class), params);
    }
}
