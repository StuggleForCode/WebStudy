package cn.itcast.jdbc.service.impl;

import cn.itcast.jdbc.Dao.Impl.UsersDaoImpl;
import cn.itcast.jdbc.Dao.UsersDao;
import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UsersDao dao = new UsersDaoImpl();

    @Override
    public void insertUser(User user) throws SQLException {
        dao.insertUser(user);
    }

    @Override
    public List<User> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public User find(int id) {
        return dao.findById(id);
    }

    @Override
    public void del(int id) {
        dao.del(id);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public List<User> findUserByManyCondition(String uId, String uBankId, String uName) throws SQLException {
        return dao.findUserByManyCondition(uId, uBankId, uName);
    }
}
