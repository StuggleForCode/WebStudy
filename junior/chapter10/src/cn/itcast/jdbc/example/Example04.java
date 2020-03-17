package cn.itcast.jdbc.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Example04 {
    public static DataSource ds = null;
    //初始化c3p0数据库
    static {
        //使用c3p0-config.xml配置文件中的named-config节点中name属性值
        ComboPooledDataSource cpds = new ComboPooledDataSource("itcast");
        ds = cpds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
