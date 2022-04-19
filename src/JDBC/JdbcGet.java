package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcGet {
    public static void main(String[] args) throws Exception {
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
