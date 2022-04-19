package JDBC;

import java.sql.*;
import java.util.ArrayList;

public class JdbcGet {
    public static void main(String[] args) throws Exception {
        JdbcGet j = new JdbcGet();
        j.PreStmt();

    }

    /**
     * @throws Exception
     * @name 防止sql注入 PreparedStatement对象
     */
    public void PreStmt() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String username = "root";
        String password = "root";

        //获取连接
        Connection conn = DriverManager.getConnection(url, username, password);

        //sql语句
        String sql = "select * from account where name= ? and id = ?";

        PreparedStatement pStmt = conn.prepareStatement(sql);

        //设置？的参数
        pStmt.setString(1, "赵五");
        pStmt.setInt(2, 4);

        //或的结果不在需要sql语句
        ResultSet rs = pStmt.executeQuery();

        ArrayList<emp> emps = new ArrayList<>();

        while (rs.next()) {
            emps.add(new emp(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("money")));
        }

        for (emp e : emps) {
            System.out.println(e);
        }

        rs.close();
        pStmt.close();
        conn.close();

    }

    /**
     * @throws Exception
     * @name Statement对象 执行sql语句并获得结果
     */
    public void Stmt() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String username = "root";
        String password = "root";

        //获取连接
        Connection conn = DriverManager.getConnection(url, username, password);

        //sql语句
        String sql = "select * from account";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        ArrayList<JDBC.emp> emps = new ArrayList<>();

        while (rs.next()) {
            emps.add(new emp(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("money")));
        }

        for (emp e : emps) {
            System.out.println(e);
        }

        rs.close();
        conn.close();
        stmt.close();
    }
}


class emp {
    private int id;
    private String name;
    private double money;

    public emp(int id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
