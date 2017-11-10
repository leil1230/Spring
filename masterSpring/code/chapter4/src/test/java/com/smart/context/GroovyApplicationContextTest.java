package com.smart.context;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GroovyApplicationContextTest {

    @Test
    public void getBean()
    {
        ApplicationContext ctx = new GenericGroovyApplicationContext("com/smart/context/groovy-beans.groovy");
        Car car = ctx.getBean("car", Car.class);
        assertNotNull(car);
        assertEquals(car.getColor(), "Gray");
    }
}
