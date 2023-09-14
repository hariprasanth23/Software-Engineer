package com.learn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// if this class has only pointcuts then @Aspect is optional
// if we have @before , @after then
@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.learn.aopdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("execution(* com.learn.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.learn.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterNoSetter(){}
}
