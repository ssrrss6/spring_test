package com.zhang.spring6.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanFactoryAware, BeanNameAware, BeanClassLoaderAware, InitializingBean, DisposableBean {
    private String name;

    public User() {
        System.out.println("第一步：创建bean。");
    }

    public void setName(String name) {
        System.out.println("第二步：给属性赋值。");
        this.name = name;
    }

    public void initBean() {
        System.out.println("第四步：初始化bean.");
    }

    public void destroyBean() {
        System.out.println("第五步：销毁bean。");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("调用了：setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用了：setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用了：setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用了：destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用了：afterPropertiesSet");
    }
}
