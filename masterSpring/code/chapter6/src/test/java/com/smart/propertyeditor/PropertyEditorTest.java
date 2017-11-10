package com.smart.propertyeditor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class PropertyEditorTest {

    @Test
    public void Test()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Boss boss = ctx.getBean("boss", Boss.class);
        boss.getCar().introduce();
    }
}
