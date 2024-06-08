package com.github.yuliyadzemidovich.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.Advice;
import org.springframework.stereotype.Component;

/**
 * AOP {@link Aspect} class that describes application behavior when AOP was triggered: <br>
 * the original method execution is being intercepted at some point (called {@link JoinPoint}) if some condition is true
 * (the condition is called {@link Pointcut}). At that moment the AOP code (called {@link Advice}) is being executed
 * instead or around the original method. The process of executing both original and AOP called is called 'weaving'.
 */
@Aspect
@Component
@Slf4j
public class TestAspect {

    /**
     * Pointcut expression (like within(..) or execution(..) can be extracted into separate statement(s)
     * as you can see below.
     */
    @Pointcut("within(com.github.yuliyadzemidovich.springaop.controller.TestController)")
    private void testController() {}
    @Pointcut("execution(public String test())")
    public void testMethod() {}

    /**
     * Same pointcut expression as "testController() && testMethod()" just written in a different way
     * for educational purposes.
     */
    @Pointcut("execution(public String com.github.yuliyadzemidovich.springaop.controller.TestController.test())")
    public void testMethodInTestController() {}

    /**
     * Advice to be executed before original method execution
     */
    @Before("testController() && testMethod()") // pointcut expression to match - if match, then the advice will be executed
    public void adviceBeforeMethod() {
        log.info("hello from advice BEFORE method execution");
    }

    /**
     * Advice to be executed after original method execution
     */
    @After("testMethodInTestController()") // pointcut expression to match - if match, then the advice will be executed
    public void adviceAfterMethod() {
        log.info("hello from advice AFTER method execution");
    }
}
