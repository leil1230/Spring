package com.smart.funinject;

import com.smart.factoryinject.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class FunInjectTest {

    @Test
    public void Test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        MagicBoss magicBoss = ctx.getBean("magicBoss", MagicBoss.class);
        Car car1 = magicBoss.getCar();
        Car car2 = magicBoss.getCar();
        System.out.println("car1 = car2 : " + (car1.hashCode() == car2.hashCode()));
    }
}
