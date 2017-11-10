package com.smart.mailsender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MailSendEvent extends ApplicationContextEvent {

    private String toAddress;

    public MailSendEvent(ApplicationContext source, String toAddress) {
        super(source);
        this.toAddress = toAddress;
    }

    public String getToAddress() {
        return toAddress;
    }
}
