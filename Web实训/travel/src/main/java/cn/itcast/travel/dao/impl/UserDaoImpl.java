package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    //拿到JdbcTemplate对象，它可以方便的操作数据用的
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean findByUsername(String username) {
        //可以帮我们返回一个对象，什么对象呢？一会再说
        //sql："select * from tab_user where username=?"
        //new BeanPropertyRowMapper<User>(User.class)：告诉JdbcTemplate我要的是什么对象
        //username:是sql的参数
        try {
            User user = jt.queryForObject("select * from tab_user where username=?",
                    new BeanPropertyRowMapper<User>(User.class), username);
            if(user!=null){
                return true;
            }
        } catch (Exception e) {

        }
        return false;

    }

    @Override
    public void regist(User user) {
        //增，删，改的方法
        jt.update(
                "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)",
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());
    }

    @Override
    public boolean active(String code) {
        int y = jt.update("update tab_user set status = ? where code = ?", "Y", code);
        return y>0;
    }

    @Override
    public User login(User user) {
        try {
            User user1 = jt.queryForObject("select * from tab_user where username=? and password=?",
                    new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            if(user1!=null){
                return user1;
            }
        } catch (DataAccessException e) {

        }
        return null;
    }
}
