package cn.itcast.itcaststore.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 当DBUtils需要收到那个控制事务时，调用该方法获得一个连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        Connection con = t1.get();
        if(con == null){
            con = dataSource.getConnection();
            t1.set(con);
        }
        return  con;
    }

    /**
     * 开启事务
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException{
        Connection con = getConnection();
        if(con != null){
            con.setAutoCommit(false);
        }
    }

    /**
     * 从ThreadLocal中释放并且关闭Connection,并结束事务
     * @throws SQLException
     */
    public static void releaseAndCloseConnection() throws SQLException{
        Connection con = getConnection();
        if(con != null){
            con.commit();
            t1.remove();
            con.close();
        }
    }

    /**
     * 事务回滚
     * @throws SQLException
     */
    public static void rollback() throws SQLException{
        Connection con = getConnection();
        if(con != null){
            con.rollback();
        }
    }

}
