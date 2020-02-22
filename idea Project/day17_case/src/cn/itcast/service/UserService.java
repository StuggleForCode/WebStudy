package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
    /**
     * 登陆方法
     */
    User login(User user);

    /**
     * 保存User
     * @param user
     */
    void addUser(User user);

    /**
     * 删除User
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户信息
     * @param ids
     */
    void deleteSelectUserById(String[] ids);
}
