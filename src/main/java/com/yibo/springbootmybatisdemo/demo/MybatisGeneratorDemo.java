package com.yibo.springbootmybatisdemo.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * @author: wb-hyb441488
 * @Date: 2019/1/2 19:41
 * @Description:
 */
public class MybatisGeneratorDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");
        Reader reader = new InputStreamReader(inputStream,"UTF-8");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object obj = sqlSession.selectOne("com.yibo.springbootmybatisdemo.mapper.UserDOMapper.selectByPrimaryKey", 1);
        sqlSession.close();
    }
}
