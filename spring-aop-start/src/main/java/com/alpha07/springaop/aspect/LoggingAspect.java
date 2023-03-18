package com.alpha07.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // LOGGING ASPECT
    // All advices related to logging will be added here only

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println(">> @Before advice for addAccount() method");
    }
}
