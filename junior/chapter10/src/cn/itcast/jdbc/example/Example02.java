package cn.itcast.jdbc.example;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Example02 {
    public static DataSource ds = null;
    static {
        //新建一个配置文件对象
        Properties prop = new Properties();
        try {
            //通过类加载器找到文件路径，读配置文件
            InputStream in = new Example02().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
            //把文件以输出流的形式加载到配置对象中
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        //获取数据库连接对象
        Connection conn = ds.getConnection();
        //获取数据库连接信息
        DatabaseMetaData metaData = conn.getMetaData();
        //打印数据库连接信息
        System.out.println(metaData.getURL() + ", UserName=" +
                metaData.getUserName() + "," + metaData.getDriverName());
    }
}
