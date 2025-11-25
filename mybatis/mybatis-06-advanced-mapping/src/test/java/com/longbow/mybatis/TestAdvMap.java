package com.longbow.mybatis;

import com.longbow.mybatis.mapper.ClassMapper;
import com.longbow.mybatis.mapper.StudentMapper;
import com.longbow.mybatis.pojo.Class;
import com.longbow.mybatis.pojo.Student;
import com.longbow.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestAdvMap {
    @Test
    public void testByResultMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectBySidStep1(3);
        System.out.println(student);

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void testOneForMul() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Class clazz = mapper.selectResultMapStep1(1001);
        System.out.println(clazz);

        sqlSession.close();
    }
}
