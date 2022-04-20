package com.chunqi;

import com.chunqi.mapper.UserMapper;
import com.chunqi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 代理开发
 */

public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件获取工厂类
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql语句
        //List<Object> users = sqlSession.selectList("test.selectAll");
        //获取userMapper对应接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();


        //4.打印输出
        System.out.println(users);

        //5.释放资源
        sqlSession.close();
    }
}
