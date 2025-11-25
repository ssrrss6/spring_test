package com.longbow.mybatis.myppers;

import com.longbow.mybatis.pojo.Car;

public interface CarMapper {
    Car SelectById(Car car);

    int Insert(Car car);
    int DeleteById(Long id);
    int updateByBrand(Car car, String brand);
}
