package cn.itcast.jdbc.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Example03 {
    public static DataSource ds = null;
    //初始化C3P0数据源
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //设置连接数据库所需要的配置信息
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc");
            cpds.setUser("root");
            cpds.setPassword("root");
            //设置连接池的参数
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(15);
            ds = cpds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
