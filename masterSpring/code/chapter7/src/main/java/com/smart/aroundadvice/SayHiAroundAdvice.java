package com.smart.aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SayHiAroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("你好！");

        Object obj = methodInvocation.proceed();

        System.out.println("再见！");
        return obj;
    }
}
