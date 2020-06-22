package cn.itcast.travel.service;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;

public interface UserService {
    ResultInfo regist(User user);

    boolean active(String code);

    User login(User user);
}
