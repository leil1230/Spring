package com.smart.factoryinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactoryInjectTest {

    @Test
    public void Test()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Car car = ctx.getBean("car", Car.class);
        assertNotNull(car);
        car.introduce();
    }
}
