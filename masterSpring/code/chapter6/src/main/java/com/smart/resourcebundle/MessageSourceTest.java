package com.smart.resourcebundle;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

public class MessageSourceTest {
    public static void main(String[] args)
    {
        // 配置文件可以被做成数组传入
        String[] configs = {"ApplicationContext.xml"};
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configs);

        // 获取MessageSource的bean
        MessageSource messageSource = (MessageSource)ctx.getBean("myResource");
        Object[] params = {"Leil", new GregorianCalendar().getTime()};

        String str1 = messageSource.getMessage("greeting.common", params, Locale.US);
        String str2 = messageSource.getMessage("greeting.common", params, Locale.CHINA);

        System.out.println(str1);
        System.out.println(str2);
    }
}
