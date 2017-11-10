package com.smart.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib实现动态代理
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 获取代理实例
     * @param c     代理目标类
     * @return      代理类
     */
    public Object getProxy(Class c)
    {
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before");
        System.out.println(o.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("cglib after");

        return result;
    }
}
