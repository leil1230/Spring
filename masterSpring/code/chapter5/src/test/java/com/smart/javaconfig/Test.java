package com.smart.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Test {

    @org.testng.annotations.Test
    public void Test()
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);
        Map<String, String> map = (Map<String, String>)ctx.getBean("testMap");
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "=========" + entry.getValue());
        }
    }
}
