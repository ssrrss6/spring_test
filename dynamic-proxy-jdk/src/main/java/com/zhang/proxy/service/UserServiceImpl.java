package com.zhang.proxy.service;

public class UserServiceImpl implements UserService{

    @Override
    public void generate() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生成订单成功。");
    }

    @Override
    public void open() {
        try {
            Thread.sleep(123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打开成功。");
    }

    @Override
    public String getName() {
        try {
            Thread.sleep(74);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取账户名。");
        return "zhangsan";
    }
}
