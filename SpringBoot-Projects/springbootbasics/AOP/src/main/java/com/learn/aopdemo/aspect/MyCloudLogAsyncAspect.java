package com.learn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.learn.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void LogToCloud(){
        System.out.println(" Executing Cloud Log Class Aspect ");
    }
}
