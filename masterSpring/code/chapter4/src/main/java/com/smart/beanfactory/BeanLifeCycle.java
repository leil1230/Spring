package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {

    public static void main(String[] args)
    {
        LifeCycleInBeanFactory();
    }

    private static void LifeCycleInBeanFactory()
    {
        // ①装载配置文件并启动容器
        Resource res = new ClassPathResource("com/smart/beanfactory/beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);

        // ②向容器中注册MyBeanPostProcessor后处理器
        ((DefaultListableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());

        // ③向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((DefaultListableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car)(bf.getBean("car"));

        // 第二次从容器中取car
        Car car2 = (Car)(bf.getBean("car"));
        car2.setBrand("Audi");
        car2.setColor("红色");
        System.out.println("=================car1=================" + car1.hashCode());
        car1.introduce();
        System.out.println("=================car2=================" + car2.hashCode());
        car2.introduce();
        System.out.println("car1 == car2: " + (car1 == car1));

        // 关闭容器
        ((DefaultListableBeanFactory)bf).destroySingletons();
    }
}
