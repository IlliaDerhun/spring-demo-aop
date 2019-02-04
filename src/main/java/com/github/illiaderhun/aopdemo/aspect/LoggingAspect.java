package com.github.illiaderhun.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /**
     * execution(modifiers-pattern?
     * return-type-pattern declaring-type-pattern?
     * method-name-pattern(param-pattern) throw-pattern?)
     * <p>
     * To reuse your pointcut declaration and don't copy past it use @Pointcut("YourExpression")
     * <p>
     * You can combine few pointcut declaration in one use &&, || or ! => @Before(theFirst() && theSecond())
     * <p>
     * To put your aspects into some order use @Order(1) or @Order(from Integer.MIN_VALUE to Integer.MAX_VALUE)
     * <p>
     * To get the parameters passed into method we should use JoinPoint int pointcut params =>
     * =>   @Before("blah-blah") public void someMethodName(JoinPoint point)
     *
     * Also have
     * @AfterReturning(pointcut="someExpression", returning="result") public void method(TypeOfResult result)
     * @AfterThrowing(pointcut="someExpression", throwing="paramNameForThrowing") public void method(Throwable paramNameForThrowing)
     * @After(someExpression) works the same like @Before but after method finished its work
     * @Around(someExpression) works like @Before and @Around =>
     * =>   @Around(someExpression)
     *      public Object someMethodName(ProceedingJoinPoint theName) {Object res = theName.proceed(); ...return res;}
     */

    @Before("execution(public void com.github.illiaderhun.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeCertainAddAccountAdvice() {

        System.out.println("\n======>>> Specifically @Before");
    }

    @Before("execution(public void addAccount())")
    public void beforeAllAddAccountAdvice() {

        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }

    @Before("execution(public void add*())")
    public void beforeAllAddMethods() {
        System.out.println("\n======>>> Executing @Before advice on add+any name()");
    }

    @Pointcut("execution(* com.github.illiaderhun.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Before("forDaoPackage()")
    public void beforeAllMethodsInDao() {
        System.out.printf("+++++++++");
    }
}
