package com.zhang.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    // invoke上三个参数
    // - 第一个参数：Object proxy。代理对象。
    // 设计这个参数只是为了后期的方便，如果想在invoke方法中使用代理对象的话，尽管通过这个参数来使用。
    //- 第二个参数：Method method。目标方法。
    //- 第三个参数：Object[] args。目标方法调用时要传的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 增强前代码
        long begin = System.currentTimeMillis();

        // 调用目标对象的目标方法
        Object retValue = method.invoke(target, args);

        // 增强后代码
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));

        return retValue;
    }
}
