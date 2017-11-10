package com.smart.beforeadvice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 问好的前置增强类
 */
public class GreetingBeforeAdvie implements MethodBeforeAdvice {
    /**
     * 问候的前置增强
     * @param method    增强的方法名称
     * @param objects   增强方法的参数
     * @param o          要增强的目标类实例
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = objects[0].toString();
        System.out.println("How are you! " + clientName);
    }
}
