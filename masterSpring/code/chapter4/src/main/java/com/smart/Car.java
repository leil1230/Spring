package com.smart;

import groovy.ui.SystemOutputInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;

    private String color;

    private int maxSpeed;

    private String name;

    private BeanFactory beanFactory;

    private String beanName;

    public Car()
    {
        System.out.println("调用Car()构造函数");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("调用setColor()设置属性");
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        System.out.println("调用setMaxSpeed()设置属性");
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用setName()设置属性");
        this.name = name;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public String toString()
    {
        return "brand:" + brand + "/color:" + color + "/maxSpeed:" + maxSpeed;
    }

    public void introduce()
    {
        System.out.println("induce:" + toString());
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()");
    }

    public void afterPropertiesSet() throws Exception {
        // 手动调用设置属性的方法后才会调用
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    public void myInit()
    {
        System.out.println("调用自定义初始化函数，将maxSpeed设置为240");
        maxSpeed = 240;
    }

    public void myDestory()
    {
        System.out.println("调用自定义销毁函数");
    }
}
