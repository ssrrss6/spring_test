package com.zhang.spring6.annotation.service.impl;

import com.zhang.spring6.annotation.dao.StudentDao;
import com.zhang.spring6.annotation.service.StudnetService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("studentServiceBean")
public class StudentServiceImpl implements StudnetService {
    @Value("zhangsan")
    private String name;
    @Value("30")
    private int age;
    @Resource(name = "studnetDaoBean")
    private StudentDao studentDao;

    @Override
    public void insert() {
        System.out.println("StudentServiceImpl running....");
    }

    @Override
    public String toString() {
        return "StudentServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentDao=" + studentDao +
                '}';
    }
}
