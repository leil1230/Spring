package com.smart.factoryinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParentInjectTest {

    @Test
    public void Test()
    {
        // 父容器
        ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext("bean1.xml");
        // 指定pFactory为factory的父容器
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{"bean2.xml"}, pFactory);
        Boss boss = factory.getBean("boss", Boss.class);
        assertNotNull(boss);
        boss.introduceCar();
    }
}
