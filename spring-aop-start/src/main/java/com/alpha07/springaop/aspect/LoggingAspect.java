package com.alpha07.springaop.aspect;

import com.alpha07.springaop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    // LOGGING ASPECT
    // All advices related to logging will be added here only

    @Pointcut("execution(public * *(..))")
    public void forAll() {}

    @Pointcut("execution(* com.alpha07.springaop.dao.AccountDAO.findAccounts(..))")
    public void forFindAccount() {}

    @Before("forAll()")
    public void beforeAll(JoinPoint joinPoint) {
        System.out.println(">> Execution of method " + joinPoint.getSignature() + " started!");
    }

    @AfterReturning(pointcut = "forFindAccount()", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        System.out.println(">> Method : " + joinPoint.getSignature()); // matched method signature
        System.out.println(">> Result : " + result); // returned value

        // Modify the returned value
        convertLevelToLowerCase(result);
    }

    @AfterThrowing(pointcut = "forFindAccount()", throwing = "exception")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable exception){
        System.out.println(">> Method : " + joinPoint.getSignature()); // matched method signature
        System.out.println(">> @AfterThrowing exception : " + exception);
    }

    @After("forAll()")
    public void afterAll(JoinPoint joinPoint){
        System.out.println(">> Method : " + joinPoint.getSignature() + " executed!");
    }

    private void convertLevelToLowerCase(List<Account> result) {
        for (Account account : result) {
            String lowerCaseLevel = account.getLevel().toLowerCase();
            account.setLevel(lowerCaseLevel);
        }
    }
}
