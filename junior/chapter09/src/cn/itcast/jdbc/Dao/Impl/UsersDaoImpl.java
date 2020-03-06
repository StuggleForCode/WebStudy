package cn.itcast.jdbc.Dao.Impl;

import cn.itcast.jdbc.Dao.UsersDao;
import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    @Override
    public boolean insertUser(User user) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(user.getuBirthday());
            String sql = "INSERT INTO users(Uid, Uname, Upassword, Ubirthday, Uaddress, UBankId)" +
                    "VALUES(" + user.getuId() + ",'" + user.getuName() + "','" + user.getuPassword() + "','" + birthday
                    +"','" + user.getuAddress() + "','" + user.getuBankId() + "')";
           // System.out.println(sql);
            int num = stmt.executeUpdate(sql);
            if(num > 0) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt,conn);
        }

        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "Select * from users";
            rs = stmt.executeQuery(sql);
            //处理结果集
            while (rs.next()){
                User user = new User();
                user.setuId(rs.getInt("Uid"));
                user.setuName(rs.getString("Uname"));
                user.setuPassword(rs.getString("Upassword"));
                user.setuBirthday(rs.getDate("Ubirthday"));
                user.setuAddress(rs.getString("Uaddress"));
                user.setuBankId(rs.getString("UbankId"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    @Override
    public User find(int id) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "Select * from users where Uid = " + id;
            rs = stmt .executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setuId(rs.getInt("Uid"));
                user.setuName(rs.getString("Uname"));
                user.setuPassword(rs.getString("Upassword"));
                user.setuBirthday(rs.getDate("Ubirthday"));
                user.setuAddress(rs.getString("Uaddress"));
                user.setuBankId(rs.getString("UbankId"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    @Override
    public boolean del(int id) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM users WHERE Uid = " + id;
            int num = stmt.executeUpdate(sql);
            if(num > 0) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(user.getuBirthday());
            String sql = "UPDATE users set Uname = '" + user.getuName() + "', Upassword= '" + user.getuPassword() + "', Ubirthday= '" + birthday
                    +"', Uaddress= '" + user.getuAddress() + "',UBankId= '" + user.getuBankId() +"' " + "WHERE Uid = " + user.getuId();
            //System.out.println(sql);
            int num = stmt.executeUpdate(sql);
            if(num > 0) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }
}
