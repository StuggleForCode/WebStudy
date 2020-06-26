package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;

public interface UserService {
    PageBean findUserFavPage(int uid, int currentPage, int pageSize);

    ResultInfo regist(User user);

    boolean active(String code);

    User login(User user);
}
