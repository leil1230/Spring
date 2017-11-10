package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CarLifeCycle {

    public static void main(String[] args)
    {
        CarLifeCycleInApplicationContext();
    }

    public static void CarLifeCycleInApplicationContext()
    {
//        Resource res = new ClassPathResource("com/smart/beanfactory/beans.xml");
//        BeanFactory bf = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
//        reader.loadBeanDefinitions(res);
//
//        Car car = (Car)bf.getBean("car");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/beanfactory/beans.xml");
        Car car = ctx.getBean("car", Car.class);

        car.introduce();
    }

}
