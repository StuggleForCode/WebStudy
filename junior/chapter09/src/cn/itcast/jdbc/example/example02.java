package cn.itcast.jdbc.example;

import java.sql.*;

public class example02 {
    public static void main(String[] args) throws SQLException{
        Connection conn = null;
        PreparedStatement preStmt = null;

        try {
            //1.注册数据库的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.通过DriveManager获取数据库连接
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            String sql  = "Select * from users";
            preStmt = conn.prepareStatement(sql);

            ResultSet resultSet = preStmt.executeQuery();
            System.out.println("Uid  |  Uname | Upassword  |  Ubirthday  |  Uaddress        | UbankId");
            while(resultSet.next()){
                int uid = resultSet.getInt("Uid");
                String uname = resultSet.getString("Uname");
                String upassword = resultSet.getString("Upassword");
                Date ubirthday = resultSet.getDate("Ubirthday");
                String uaddress = resultSet.getString("Uaddress");
                String ubankId = resultSet.getString("UBankId");
                System.out.println(uid + " | " + uname + " | " + upassword  + " | " + ubirthday  + " | " + uaddress  + " | " +
                        ubankId);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(preStmt != null){
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                preStmt = null;
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
