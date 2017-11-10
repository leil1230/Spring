package com.smart.aroundadvice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloAroundAdvice {

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloWorld helloWorld = (HelloWorld)ctx.getBean("proxyHelloWorld");
        helloWorld.sayHi();
    }
}
