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

        //2.��ȡsqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.��ȡmapper����
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.ִ�з���
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        //5.�ͷ���Դ
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("������Ҫ��ѯ��id");
        int id = 1;

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡsqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.��ȡmapper����
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.ִ�з���
        List<Brand> brands = mapper.selectById(id);
        System.out.println(brands);

        //5.�ͷ���Դ
        sqlSession.close();

    }

    @Test
    public void selectByCondition() throws IOException {
        Scanner sc = new Scanner(System.in);

        int status = 1;
        String companyName = "��";
        String brandName = "Ϊ";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡsqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.��ȡmapper����
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //��װ����
//        Brand brand = new Brand();
//        brand.setSTATUS(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //����Map
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //4.ִ�з���
        //List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);

        //�������
//        List<Brand> brands = mapper.selectByCondition(brand);

        //����Map
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands);

        //5.�ͷ���Դ
        sqlSession.close();

    }
}
