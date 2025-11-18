package com.zhang.spring6.annotation;

import com.zhang.spring6.annotation.service.StudnetService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void testDIByAnnotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudnetService studentServiceBean = context.getBean("studentServiceBean", StudnetService.class);
        System.out.println(studentServiceBean);
        studentServiceBean.insert();
    }
    
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Vip vip = applicationContext.getBean("vip", Vip.class);
        System.out.println(vip);
    }
}
