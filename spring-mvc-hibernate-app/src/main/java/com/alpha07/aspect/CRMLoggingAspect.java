package com.alpha07.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CRMLoggingAspect {

    // Define a logger
    private final Logger logger = Logger.getLogger(getClass().getName());

    // Setup pointcut declarations
    @Pointcut("execution(* com.alpha07.controller.*.*(..))")
    public void forControllerPackage() {
    }

    @Pointcut("execution(* com.alpha07.service.*.*(..))")
    public void forServicePackage() {
    }

    @Pointcut("execution(* com.alpha07.dao.*.*(..))")
    public void forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    public void forAppActions() {
    }

    @Before("forAppActions()")
    public void preLogging(JoinPoint joinPoint) {

        // Print target method
        logger.info("Initializing : " + joinPoint.getSignature().toShortString());

        // Print target method arguments
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("arg : " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppActions()",returning = "result")
    public void postLogging(JoinPoint joinPoint, Object result){

        // Print target method
        logger.info("Initializing : " + joinPoint.getSignature().toShortString());

        // Print the target method results
        logger.info("result : " + result);
    }
}
