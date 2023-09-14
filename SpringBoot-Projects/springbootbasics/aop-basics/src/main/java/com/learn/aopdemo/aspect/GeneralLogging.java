package com.learn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class GeneralLogging {

    @Before("execution(* com.learn.aopdemo.dao.*.*(..))")
    public void BeforeAdvice(){
        System.out.println("Using Before Advice");
    }
}
