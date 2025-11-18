package com.zhang.aop.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopByAnno {
    @Test
    public void testAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);

        user.login();
    }
}
