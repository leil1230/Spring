package com.smart.beanfactory;

import com.smart.Apple;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AppleLifeCycle {

    public static void main(String[] args)
    {
        AppleLifeCycleInBeanFactory();
    }

    public static void AppleLifeCycleInBeanFactory()
    {
        Resource res = new ClassPathResource("com/smart/beanfactory/beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);
        ((DefaultListableBeanFactory)bf).addBeanPostProcessor(new MyInitDestroyAnnotationBeanPostProcessor());

        Apple apple = (Apple) bf.getBean("apple");
        apple.destroy();
    }
}
