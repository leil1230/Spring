package com.smart.annotation;

import com.smart.factorybean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class Boss {
    private Car car;

    @Autowired
    public void setCar(Car car) {
        System.out.println("设置car");
        this.car = car;
    }

    @PostConstruct
    public void init1()
    {
        System.out.println("初始化方法1");
    }

    @PostConstruct
    public void init2()
    {
        System.out.println("初始化方法2");
    }

    @PreDestroy
    public void destroy1()
    {
        System.out.println("销毁方法1");
    }

    @PreDestroy
    public void destroy2()
    {
        System.out.println("销毁方法2");
    }

    public void introduceCar()
    {
        car.introduce();
    }


}
