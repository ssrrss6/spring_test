package com.longbow.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.TypeDescriptor;
import java.util.Map;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行sql语句
        int insertCar = sqlSession.insert("insertCar");
        System.out.println("插入的数据数：" + insertCar);
        sqlSession.commit();
    }
}
