package com.yibo.springbootmybatisdemo.demo;

import com.yibo.springbootmybatisdemo.entity.UserDO;
import com.yibo.springbootmybatisdemo.mapper.CustomUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author: wb-hyb441488
 * @Date: 2019/1/2 19:41
 * @Description:
 */
public class MybatisGeneratorDemo2 {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomUserMapper userMapper = sqlSession.getMapper(CustomUserMapper.class);
        UserDO userDO = userMapper.selectUser(1);
        System.out.println(userDO);
        sqlSession.close();
    }
}
