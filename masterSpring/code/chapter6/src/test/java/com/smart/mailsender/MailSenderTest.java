package com.smart.mailsender;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class MailSenderTest {
    @Test
    public void Test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        MailSender mailSender = ctx.getBean("mailSender", MailSender.class);
        mailSender.sendMail("leil1230@qq.com");
    }
}
