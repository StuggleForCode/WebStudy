package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void del(int parseInt);

    User findUserById(int parseInt);

    void updateUser(User user);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(int start, int rows);
}
