package com.learn.aopdemo.aspect;

import com.learn.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    /*
    1. To execute for all method named as addAccount
        - @Before("execution(public void addAccount())")
    2. To execute only for that particular class
        - @Before("execution(public void com.learn.aopdemo.dao.AccountDAO.addAccount())")
    3. To execute all method name starting with add
        - @Before("execution(public void add*())")
    4. return type as void and any method name starting with add
        - @Before("execution(void add*())")
    5. Any return type and any Method name starting with add
        - @Before("execution(* add*())")
    6. Any Method having Account as Single parameter and return type as void
        - @Before("execution(void add*(com.learn.aopdemo.entity.Account))")
        - Needed fully qualified parameter , otherwise it will show error
    7. Method's First Paramter should be Account and after that any type and any number of paramter's can be there
        - @Before("execution(void add*(com.learn.aopdemo.entity.Account, ..))")
    8. Any Return Type , Any number of Parameter, Any Method name starting with add
        - @Before("execution(* add*(..))")
    9. Any Return Type , Any Number of Parameter , Any Class , Any Method Name ,
        But within the Current Package
        - @Before("execution(* com.learn.aopdemo.dao.*.*(..))")

    @Before("execution(* com.learn.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println(" Executing @Before advice on add*()");
    }
*/



    @Before("execution(public void com.learn.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("class(MyDemoLoggingAspect)-->Method(beforeAddAccountAdvice)-->Executing @Before advice on add*()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("method Signature"+methodSignature);
        Object[] args = joinPoint.getArgs();
        for(Object tempArg : args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                Account theAccount = (Account) tempArg;
                System.out.println("account name:"+theAccount.getName());
                System.out.println("account level"+theAccount.getLevel());
            }
        }
    }

    @AfterReturning( pointcut = "execution(* com.learn.aopdemo.dao.AccountDAO.findAccounts(..))" , returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing after Returning on method"+method);
        System.out.println("result"+result);
        convertAccountNamesToUpperCase(result);
        System.out.println("result--> after modifing"+result);
    }


    private void convertAccountNamesToUpperCase(List<Account> result){
        for(Account account:result){
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.learn.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "Exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable Exception){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing after Throwing on method"+method);
        System.out.println("Exception is --->"+Exception);
    }

    @After("execution(* com.learn.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing after finally on method"+method);
    }

    /*
    @Around("execution(* com.learn.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Executing after finally on method"+method);
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println(" Duration : "+ duration/1000.0 + "seconds");
        return result;
    }

     */

    @Around("execution(* com.learn.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Executing after finally on method"+method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            result = "Major Accident Dont Worry , AOP helicopter is on he way";
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println(" Duration : "+ duration/1000.0 + "seconds");
        return result;
    }
}
