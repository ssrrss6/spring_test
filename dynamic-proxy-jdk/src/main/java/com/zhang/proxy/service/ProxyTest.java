package com.zhang.proxy.service;

import java.lang.reflect.Proxy;


public class ProxyTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.generate();
//        userService.open();
//        userService.getNmae();

        // 第一步：创建目标对象
        UserService target = new UserServiceImpl();

        // 第二步：创建代理对象
            // newProxyInstance 有三个参数
            //- 第一个参数：类加载器。在内存中生成了字节码，要想执行这个字节码，
            // 也是需要先把这个字节码加载到内存当中的。所以要指定使用哪个类加载器加载。
            //- 第二个参数：接口类型。代理类和目标类实现相同的接口，
            // 所以要通过这个参数告诉JDK动态代理生成的类要实现哪些接口。
            //- 第三个参数：调用处理器。这是一个JDK动态代理规定的接口，
            // 接口全名：java.lang.reflect.InvocationHandler。
            // 显然这是一个回调接口，也就是说调用这个接口中方法的程序已经写好了，就差这个接口的实现类了。
        UserService newProxyInstance = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                                            target.getClass().getInterfaces(),
                                                                            new MyInvocationHandler(target));

        // 调用代理对象的代理方法
        newProxyInstance.generate();
        newProxyInstance.open();
        String name = newProxyInstance.getName();
        System.out.println(name);
    }
}
