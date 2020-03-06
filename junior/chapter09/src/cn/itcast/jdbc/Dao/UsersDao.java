package cn.itcast.jdbc.Dao;

import cn.itcast.jdbc.domain.User;

import java.util.List;

public interface UsersDao {

    /**
     * 插入数据，插入成功返回true
     * @param user
     * @return
     */
    public boolean insertUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查找指定的user
     * @param id
     * @return
     */
    public User find(int id);

    /**
     * 根据id删除指定的user
     * @param id
     * @return
     */
    public boolean del(int id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public boolean update(User user);
}
