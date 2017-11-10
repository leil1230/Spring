package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

public class MyInitDestroyAnnotationBeanPostProcessor extends InitDestroyAnnotationBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("apple"))
        {
            System.out.println("苹果初始化之前");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("apple"))
        {
            System.out.println("苹果初始化之后");
        }
        return bean;
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("苹果销毁之前");
        super.postProcessBeforeDestruction(bean, beanName);
    }
}
