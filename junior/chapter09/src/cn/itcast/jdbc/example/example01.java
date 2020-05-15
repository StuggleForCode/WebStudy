package cn.itcast.jdbc.example;

import java.sql.*;

public class example01 {
    public static void main(String[] args) throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            //1.注册数据库的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.通过DriveManager获取数据库连接
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            //3.通过Connection对象获取Statement对象
            stmt = conn.createStatement();
            //4.使用Statement执行Sql语句
            String sql  = "Select * from users";
            rs = stmt.executeQuery(sql);
            //5.操作ResultSet结果集
            System.out.println("Uid  |  Uname | Upassword  |  Ubirthday  |  Uaddress        | UbankId");
            while (rs.next()){
                int uid = rs.getInt("Uid");
                String uname = rs.getString("Uname");
                String upassword = rs.getString("Upassword");
                Date ubirthday = rs.getDate("Ubirthday");
                String uaddress = rs.getString("Uaddress");
                String ubankId = rs.getString("UBankId");
                System.out.println(uid + " | " + uname + " | " + upassword  + " | " + ubirthday  + " | " + uaddress  + " | " +
                        ubankId);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6.回收数据库资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}