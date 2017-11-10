package com.smart.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class FactoryBeanTest {

    @Test
    public void Test()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        // 获取Car实例
        Car car = ctx.getBean("car1", Car.class);
        car.introduce();
        // 获取CarFactoryBean实例
        CarFactoryBean carFactoryBean = ctx.getBean("&car1", CarFactoryBean.class);
        carFactoryBean.sayHi();
    }
}
