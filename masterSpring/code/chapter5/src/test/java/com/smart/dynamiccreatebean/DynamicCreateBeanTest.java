package com.smart.dynamiccreatebean;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicCreateBeanTest {

    @Test
    public void Test()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService1 = ctx.getBean("userService1", UserService.class);
        UserService userService2 = ctx.getBean("userService2", UserService.class);
        assertNotNull(userService1);
        assertNotNull(userService2);
        assertNotEquals(userService1, userService2);
        //assertEquals(userService1, userService2);
        userService1.getUserDao().sayHi();
        userService2.getUserDao().sayHi();
    }
}
