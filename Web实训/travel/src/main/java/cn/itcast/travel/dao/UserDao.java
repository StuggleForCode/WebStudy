package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    boolean findByUsername(String username);

    void regist(User user);

    boolean active(String code);

    User login(User user);
}
