package com.smart.mailsender;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MailSender implements ApplicationContextAware {

    private ApplicationContext ctx;

    // 实现ApplicationContextAware用于获取ApplicationContext实例  （容器启动时注入容器实例）
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public void sendMail(String toAddress)
    {
        System.out.println("模拟邮件发送。。。");
        MailSendEvent mse = new MailSendEvent(ctx, toAddress);

        // 发布事件
        ctx.publishEvent(mse);
    }


}
