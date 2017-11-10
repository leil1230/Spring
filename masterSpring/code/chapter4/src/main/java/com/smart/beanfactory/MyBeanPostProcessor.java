package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car"))
        {
            Car car = (Car)bean;
            if (car.getColor() == null)
            {
                System.out.println("MyBeanPostProcessor=====调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置默认为黑色");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (s.equals("car"))
        {
            Car car = (Car)o;
            if (car.getMaxSpeed() > 200)
            {
                System.out.println("MyBeanPostProcessor=====调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }
}
