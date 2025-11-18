package com.zhang.myspring;

import com.zhang.myspring.bean.User;
import com.zhang.myspring.bean.UserService;
import com.zhang.myspring.myspringframework.core.ApplicationContext;
import com.zhang.myspring.myspringframework.core.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.Map;

public class TestSpringFramework {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        userService.save();
    }

    @Test
    public void testGetBean(){
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("myspring.xml");

        Map<String, Object> singletonObjects = c.getSingletonObjects();
        System.out.println(singletonObjects);

        Object user = singletonObjects.get("user");
        System.out.println(user); // 结果：User{name='zhangsan', age=18}

        Object user1 = c.getBean("user");
        System.out.println(user1); // 结果：null
    }
}
