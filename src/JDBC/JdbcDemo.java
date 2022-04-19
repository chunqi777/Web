package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String username = "root";
        String password = "root";

        //获取连接
        Connection conn = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入名字:");
        String name = "sc.next()";
//        System.out.print("请输入工资:");
//        int salary = sc.nextInt();
        String s = sc.next();

        //sql语句
        String sql1 = "UPDATE account SET money = 2000 WHERE id = 1";
        String sql2 = "UPDATE account SET money = 3000 WHERE id = 2";
        String sql3 = "insert into account (name,money) values('" + name + "')";
        String sql4 = "select * from account where name = '" + name + "' and name='" + s + "'";
        System.out.println(sql4);

        //获取执行sql的对象
        Statement stmt = conn.createStatement();


        try {
            //开启事务
            conn.setAutoCommit(false);

            //执行sql语句
            int count1 = stmt.executeUpdate(sql1);

            System.out.println("受影响的行数：" + count1);

            int count2 = stmt.executeUpdate(sql2);

            System.out.println("受影响的行数：" + count2);

            int count3 = stmt.executeUpdate(sql3);
            if (count3 > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }

            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();

            e.printStackTrace();
        }


        ResultSet rs = stmt.executeQuery(sql4);
        if (rs.next()) {
            System.out.println("successful");
        } else {
            System.out.println("wrong");
        }

        //释放资源
        stmt.close();
        conn.close();
        sc.close();
    }
}
