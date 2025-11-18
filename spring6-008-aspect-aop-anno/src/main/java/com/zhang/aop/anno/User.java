package com.zhang.aop.anno;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class User {
    public void login() {
        System.out.println("用户登录成功");
    }
}
