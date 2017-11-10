package com.smart.resourcebundle;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

public class ReloadableResourceBundleTest {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        ReloadableResourceBundleMessageSource messageSource = ctx.getBean("myResource", ReloadableResourceBundleMessageSource.class);
        Object[] params = {"Leil", new GregorianCalendar().getTime()};

        System.out.println(messageSource.getMessage("greeting.common", null, Locale.US));
        Thread.currentThread().sleep(60000);
        System.out.println(messageSource.getMessage("greeting.common", null, Locale.US));
    }

}
