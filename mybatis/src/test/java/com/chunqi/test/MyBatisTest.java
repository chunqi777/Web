package com.chunqi.test;

import com.chunqi.mapper.BrandMapper;
import com.chunqi.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要查询的id");
        int id = 1;

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectById(id);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void selectByCondition() throws IOException {
        Scanner sc = new Scanner(System.in);

        int status = 1;
        String companyName = "华";
        String brandName = "为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //封装对象
//        Brand brand = new Brand();
//        brand.setSTATUS(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //创建Map
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //4.执行方法
        //List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);

        //传入对象
//        List<Brand> brands = mapper.selectByCondition(brand);

        //传入Map
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands);

        //5.释放资源
        sqlSession.close();

    }
}
