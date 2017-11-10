package com.smart.jdkproxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    /**
     * 目标代理对象
     */
    private Object target;

    public MyInvocationHandler(Object target)
    {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在方法执行前调用。。。。。");

        Object result = method.invoke(target, args);

        System.out.println("在方法执行后调用。。。。。");

        return result;
    }

    /**
     * 获取代理对象
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
