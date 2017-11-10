package com.smart.funinject;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Boss2 implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("我是boss2中的方法，要替换boss1中的方法");
        return null;
    }
}
