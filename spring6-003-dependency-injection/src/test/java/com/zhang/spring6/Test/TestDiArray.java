package com.zhang.spring6.Test;

import com.zhang.spring6.bean.Person;
import com.zhang.spring6.bean.QianDaye;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDiArray {

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person.toString());
    }
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        QianDaye qianDaye = applicationContext.getBean("yuqian", QianDaye.class);

        System.out.println(qianDaye.toString());

    }
}
