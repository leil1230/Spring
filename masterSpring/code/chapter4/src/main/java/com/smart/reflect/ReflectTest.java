package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] ages) throws Throwable {
        Child child = initByDefaultConst();
        child.introduce();
    }

    public static Child initByDefaultConst() throws Throwable
    {
        // ①通过类装载器获取Child类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class c = loader.loadClass("com.smart.reflect.Child");

        // ②获取类的默认构造器对象并通过它实例化Child
        Constructor cons = c.getDeclaredConstructor((Class[])null);
        Child child = (Child)cons.newInstance();

        Method setName = c.getMethod("setName", String.class);
        setName.invoke(child, "小明");
        Method setAge = c.getMethod("setAge", int.class);
        setAge.invoke(child, 20);

        return child;
    }
}
