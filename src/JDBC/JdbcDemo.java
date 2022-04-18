package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String username = "root";
        String password = "root";

        //获取连接
        Connection conn = DriverManager.getConnection(url, username, password);

        //sql语句
        String sql1 = "UPDATE account SET money = 2000 WHERE id = 1";

        //获取执行sql的对象
        Statement stmt = conn.createStatement();

        //执行sql语句
        int count = stmt.executeUpdate(sql1);

        System.out.println("受影响的行数：" + count);

        //释放资源
        stmt.close();
        conn.close();
    }
}
