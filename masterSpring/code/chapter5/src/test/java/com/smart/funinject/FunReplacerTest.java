package com.smart.funinject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class FunReplacerTest {
@Test
    public void Test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Boss1 boss1 = ctx.getBean("boss1", Boss1.class);
        boss1.Talk();
    }
}
