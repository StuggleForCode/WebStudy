package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;

import java.util.List;

public interface UserDao {
    boolean findByUsername(String username);

    void regist(User user);

    boolean active(String code);

    User login(User user);

    int findUserFavPageCount(int uid);

    List<Route> findUserFavPage(int uid, int currentPage, int pageSize);
}
