package com.smart.beforeadvice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WaiterAdvice {

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Waiter waiter = (Waiter)ctx.getBean("waiterProxy");
        waiter.greetTo("XiaoMing");
    }
}
