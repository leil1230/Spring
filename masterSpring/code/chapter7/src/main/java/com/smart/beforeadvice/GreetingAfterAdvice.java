package com.smart.beforeadvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class GreetingAfterAdvice implements AfterReturningAdvice {
    /**
     * 后置增强
     * @param returnObj     返回对象
     * @param method        增强的目标方法
     * @param objects       参数列表
     * @param targetObj     目标类实例
     * @throws Throwable
     */
    public void afterReturning(Object returnObj, Method method, Object[] objects, Object targetObj) throws Throwable {
        System.out.println("Please enjoy yourself! " + objects[0].toString());
    }
}
