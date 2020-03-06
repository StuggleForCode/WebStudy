package cn.itcast.jdbc.service.impl;

import cn.itcast.jdbc.Dao.Impl.UsersDaoImpl;
import cn.itcast.jdbc.Dao.UsersDao;
import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UsersDao dao = new UsersDaoImpl();

    @Override
    public boolean insertUser(User user) {
        return dao.insertUser(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User find(int id) {
        return dao.find(id);
    }

    @Override
    public boolean del(int id) {
        return dao.del(id);
    }

    @Override
    public boolean update(User user) {
        return dao.update(user);
    }
}
