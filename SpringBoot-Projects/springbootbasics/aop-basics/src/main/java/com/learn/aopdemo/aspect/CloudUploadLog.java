package com.learn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudUploadLog {
    @Before("com.learn.aopdemo.aspect.AopExpression.forDaoPackageNoGetterNoSetter()")
    public void UploadLogToCloud(){
        System.out.println("Uploading Log to Cloud");
    }
}
