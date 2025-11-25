package com.longbow.mybatis.mapper;

import com.longbow.mybatis.pojo.Student;

public interface StudentMapper {

    Student selectBySidStep1(Integer sid);

    Student selectResultMapStep2(Integer sid);
}
