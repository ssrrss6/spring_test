package com.longbow;

import com.longbow.mybatis.beans.Car;
import com.longbow.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestCurd {
    @Test
    public void testInsert() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Car car = new Car();
        car.setCarNum("103");
        car.setBrand("奔驰C200");
        car.setGuidePrice(33.23);
        car.setProduceTime("2020-10-11");
        car.setCarType("燃油车");

        int insertCount = sqlSession.insert("insertCar", car);
        System.out.println("插入的数据数：" + insertCount);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Car car = new Car();
        car.setId(11L);
        int deleteCount = sqlSession.delete("deleteCar", car);
        System.out.println("删除的数据数"+deleteCount);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Car car = new Car(4L, "103", "奔驰C200", 50.2, "2021-02-21", "燃油车");
        int updateCount = sqlSession.update("updateCar", car);
        System.out.println("更新的条数："+updateCount);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Car car = new Car();
        car.setId(8L);
        Object retCar = sqlSession.selectOne("selectCar", car);
        System.out.println(retCar);

        List<Object> selectAll = sqlSession.selectList("selectAll");
        selectAll.forEach(preCar -> {
            System.out.println(preCar);
        });

    }

    @Test
    public void testUtil() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object selectCar = sqlSession.selectOne("selectCar", 4);
        System.out.println(selectCar);
    }
}
