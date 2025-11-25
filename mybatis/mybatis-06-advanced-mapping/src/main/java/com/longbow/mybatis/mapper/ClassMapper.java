package com.longbow.mybatis.mapper;

import com.longbow.mybatis.pojo.Class;

public interface ClassMapper {
    Class selectByTidStep2(Integer cid);

    Class selectResultMapStep1(Integer cid);
}
