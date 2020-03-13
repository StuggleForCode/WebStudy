package cn.itcast.jdbc;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Example01 {
    public static DataSource ds = null;
    static {
        //获取DBCP数据以源实现类对象
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/jdbc");
        bds.setUsername("root");
        bds.setPassword("root");
        //设置连接池的参数
        bds.setInitialSize(5);
        bds.setMaxActive(5);
        ds = bds;
    }

    public static void main(String[] args) {
        try {
            //获取数据库连接对象
            Connection conn = ds.getConnection();
            //获取数据库连接信息
            DatabaseMetaData metaData = conn.getMetaData();
            //打印数据库连接信息
            System.out.println(metaData.getURL() + ", UserName=" +
                    metaData.getUserName() + "," + metaData.getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
