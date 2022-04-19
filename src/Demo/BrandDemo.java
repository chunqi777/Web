package Demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class BrandDemo {
    public static void main(String[] args) throws Exception {
        BrandDemo B = new BrandDemo();
        B.delete();
    }

    /**
     * @throws Exception
     * @use 查询所有数据
     */
    public void selectAll() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取Connection连接
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand;";

        PreparedStatement pStmt = conn.prepareStatement(sql);

        ResultSet rs = pStmt.executeQuery();

        ArrayList<Brand> brands = new ArrayList<>();

        while (rs.next()) {
            brands.add(new Brand(rs.getInt("id"), rs.getString("brand_name"), rs.getString("company_name"), rs.getInt("ordered"), rs.getString("description"), rs.getInt("status")));

        }

        System.out.println(brands);

        rs.close();
        pStmt.close();
        conn.close();
    }

    /**
     * @throws Exception
     * @use 添加数据
     */
    public void inSert() throws Exception {
        Scanner sc = new Scanner(System.in);
        //模拟接收页面提交参数
        System.out.println("请输入品牌名称:");
        String brandName = sc.next();

        System.out.println("请输入公司名称:");
        String companyName = sc.next();

        System.out.println("请输入排序字段:");
        Integer ordered = sc.nextInt();

        System.out.println("请输入简介:");
        String description = sc.next();

        System.out.println("是否启用:");
        Integer status = sc.nextInt();


        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取Connection连接
        Connection conn = dataSource.getConnection();

        String sql = "INSERT INTO tb_brand (brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";

        PreparedStatement pStmt = conn.prepareStatement(sql);

        pStmt.setInt(3, ordered);
        pStmt.setInt(5, status);
        pStmt.setString(1, brandName);
        pStmt.setString(2, companyName);
        pStmt.setString(4, description);

        int count = pStmt.executeUpdate();

        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        pStmt.close();
        conn.close();
    }

    /**
     * @throws Exception
     * @use 修改数据
     */
    public void upData() throws Exception {
        Scanner sc = new Scanner(System.in);
        //模拟接收页面提交参数
        System.out.println("请输入要修改品牌的id:");
        Integer id = sc.nextInt();

        System.out.println("请输入品牌名称:");
        String brandName = sc.next();

        System.out.println("请输入公司名称:");
        String companyName = sc.next();

        System.out.println("请输入排序字段:");
        Integer ordered = sc.nextInt();

        System.out.println("请输入简介:");
        String description = sc.next();

        System.out.println("是否启用:");
        Integer status = sc.nextInt();


        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取Connection连接
        Connection conn = dataSource.getConnection();

        String sql = "UPDATE tb_brand SET brand_name = ?,company_name=?,ordered=?,description=?,status=? where id=?;";

        PreparedStatement pStmt = conn.prepareStatement(sql);

        pStmt.setString(1, brandName);
        pStmt.setString(2, companyName);
        pStmt.setInt(3, ordered);
        pStmt.setString(4, description);
        pStmt.setInt(5, status);
        pStmt.setInt(6, id);

        int count = pStmt.executeUpdate();

        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        pStmt.close();
        conn.close();
    }

    /**
     * @throws Exception
     * @use 删除数据
     */
    public void delete() throws Exception {
        Scanner sc = new Scanner(System.in);
        //模拟接收页面提交参数
        System.out.println("请输入要删除品牌的id:");
        Integer id = sc.nextInt();

        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取Connection连接
        Connection conn = dataSource.getConnection();

        String sql = "DELETE FROM tb_brand WHERE id=?";

        PreparedStatement pStmt = conn.prepareStatement(sql);

        pStmt.setInt(1, id);

        int count = pStmt.executeUpdate();

        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        pStmt.close();
        conn.close();
    }
}
