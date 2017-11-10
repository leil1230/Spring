package com.smart.beforeadvice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {

    @Test
    public void test()
    {
        Waiter waiter = new NaiveWaiter();

        // 创建前置增强类实例
        BeforeAdvice advice = new GreetingBeforeAdvie();

        // 创建代理工厂
        ProxyFactory pf = new ProxyFactory();

        // 设置增强目标
        pf.setTarget(waiter);

        // 为代理目标添加增强
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("Leil");
        proxy.serveTo("Feilong");
    }
}
