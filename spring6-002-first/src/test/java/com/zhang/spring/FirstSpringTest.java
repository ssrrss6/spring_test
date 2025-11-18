package com.zhang.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void test1(){
        //ClassPathXmlApplicationContext 专门从类路径当中加载spring配置文件的一个spring上下文对象
        //启动spring容器，解析spring.xml文件，并且实例化所有的bean对象，放在spring容器当中。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 根据bean的id从spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);
    }
}
