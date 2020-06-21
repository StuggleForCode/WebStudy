package cn.itcast.jdbc.Dao;

import cn.itcast.jdbc.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {

    /**
     * 插入数据，插入成功返回true
     * @param user
     * @return
     */
    public void insertUser(User user) throws SQLException;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() throws SQLException;

    /**
     * 根据id查找指定的user
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     * 根据id删除指定的user
     * @param id
     * @return
     */
    public void del(int id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public void update(User user);

    public List<User> findUserByManyCondition(String uId, String uBankId, String uName) throws SQLException;
}
