package com.smart.mailsender;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("向" + mailSendEvent.getToAddress() + "发送邮件成功");
    }
}
