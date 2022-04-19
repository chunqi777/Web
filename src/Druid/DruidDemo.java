package Druid;

import JDBC.emp;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Druid 数据库连接
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包

        //2.导入配置文件

        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取Connection连接
        Connection conn = dataSource.getConnection();

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
    }
}
