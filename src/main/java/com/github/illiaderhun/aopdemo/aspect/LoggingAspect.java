package com.github.illiaderhun.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /**
     * execution(modifiers-pattern?
     *          return-type-pattern declaring-type-pattern?
     *          method-name-pattern(param-pattern) throw-pattern?)
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
}
