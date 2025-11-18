package com.zhang.aop.anno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("execution(* com.zhang.aop.anno..*(..))")
    public void beforeAdvice(){
        System.out.println("这是前置通知");
    }

    @AfterReturning("execution(* com.zhang.aop.anno..*(..))")
    public void afterReturningAdvice(){
        System.out.println("这是后置通知");
    }
}
