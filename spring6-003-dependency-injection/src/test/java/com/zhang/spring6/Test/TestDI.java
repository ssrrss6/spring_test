package com.zhang.spring6.Test;

import com.zhang.spring6.service.OrderService;
import com.zhang.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.insert();
    }
    
    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.insert();
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        orderService.insert();
    }



}
