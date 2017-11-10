package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable
    {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class c = loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar car = (PrivateCar)c.newInstance();

        // 获取color属性
        Field colorField = c.getDeclaredField("color");
        // 取消Java语言访问检查，以访问private变量
        colorField.setAccessible(true);
        colorField.set(car, "红色");

        // 注意：这里不可以用getMethod()直接获取方法
        Method driveMethod = c.getDeclaredMethod("drive", (Class<?>[]) null);
        driveMethod.setAccessible(true);
        driveMethod.invoke(car);
    }
}
