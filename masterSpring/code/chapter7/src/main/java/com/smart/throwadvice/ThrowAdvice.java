package com.smart.throwadvice;

import com.smart.beforeadvice.Waiter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThrowAdvice {
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ForumService service = (ForumService)ctx.getBean("forumServiceProxy");
//        service.removeForum(1);
        try {
            service.updateForum(new Forum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
