package com.smart.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleTest {
    public static void main(String[] ages)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Boss boss = ctx.getBean("boss", Boss.class);
        boss.introduceCar();
        ctx.destroy();
    }
}
