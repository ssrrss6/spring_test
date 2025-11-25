package com.longbow.mybatis;

import com.longbow.mybatis.myppers.CarMapper;
import com.longbow.mybatis.pojo.Car;
import com.longbow.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CRUDTest {
    @Test
    public void test1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

//        Car car = new Car();
//        car.setId(5L);
//        Car retCar = mapper.SelectById(car);
//        System.out.println(retCar);
//
//        Car car1 = new Car(null, "102", "凯美瑞", 34.4, "2021-11-11", "新能源");
//        int insert = mapper.Insert(car1);
//        System.out.println("插入的数据：" + insert);
//        sqlSession.commit();

//        int deleteById = mapper.DeleteById(8L);
//        System.out.println("删除的数据："+deleteById);
//        sqlSession.commit();

//        Car car = new Car(null, "104", "丰田mirai", 32.4, "2011-2-11", "燃油");
//        int updateByBrand = mapper.updateByBrand(car, "凯美瑞");
//        System.out.println("更新的数据:" + updateByBrand);
//        sqlSession.commit();


        sqlSession.close();

    }
}
