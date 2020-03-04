package cn.itcast.jdbc.example;

import java.sql.*;

public class example03 {
    public static void main(String[] args)  throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册数据库的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.通过DriveManager获取数据库连接
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            //3.通过Connection对象获取Statement对象
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "Select * from users";
            ResultSet resultSet = stmt.executeQuery(sql);

            //4.取出ResultSet中指定数据信息
            System.out.print("第一条数据的Uname值为：");
            resultSet.absolute(1);
            System.out.println(resultSet.getString("Uname"));

            resultSet.beforeFirst(); // 将指针移动到第一条数据之前
            try {
                String Uname = resultSet.getString("Uname");
            } catch (SQLException e) {
                System.out.println("指针移动到第一条数据之前，数据为空，Uname 为空");
            }
            resultSet.afterLast();
            try {
                String Uname = resultSet.getString("Uname");
            } catch (SQLException e) {
                System.out.println("指针移动到最后一条数据之后，数据为空，Uname 为空");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
