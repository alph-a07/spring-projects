package com.alpha07.springaop.aspect;

import com.alpha07.springaop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    // LOGGING ASPECT
    // All advices related to logging will be added here only

    @Pointcut("execution(public * *(..))")
    public void forAll() {
    }

    @Pointcut("execution(* com.alpha07.springaop.dao.AccountDAO.findAccounts(..))")
    public void forFindAccount() {
    }

    @Pointcut("execution(* com.alpha07.springaop.dao.AccountDAO.addAccount(..)))")
    public void forAddAccount() {
    }

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

    // @AfterThrowing(pointcut = "forFindAccount()", throwing = "exception")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println(">> Method : " + joinPoint.getSignature()); // matched method signature
        System.out.println(">> @AfterThrowing exception : " + exception);
    }

    @After("forAll()")
    public void afterAll(JoinPoint joinPoint) {
        System.out.println(">> Method : " + joinPoint.getSignature() + " executed!");
    }

    @Around("forAll()")
    public Object aroundAddAccount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Get starting timestamp
        long start = System.currentTimeMillis();

        Object result = null;

        // Execute the matched method
        try{
            // Capture the result returned by the target method
            result = proceedingJoinPoint.proceed();
        } catch (Exception e){
            System.out.println(">> No accounts here!"); // swallow the exception
            System.out.println(">> Reason : " + e.getMessage()); // notify the main app about the exception
        }

        // Get ending timestamp
        long end = System.currentTimeMillis();

        // Duration to run matched method
        System.out.println(">> Method " + proceedingJoinPoint.getSignature() + " took : " + (end - start) + " milliseconds");

        return result;
    }

    private void convertLevelToLowerCase(List<Account> result) {
        for (Account account : result) {
            String lowerCaseLevel = account.getLevel().toLowerCase();
            account.setLevel(lowerCaseLevel);
        }
    }
}
