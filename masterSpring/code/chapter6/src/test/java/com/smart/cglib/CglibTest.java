package com.smart.cglib;

import org.testng.annotations.Test;

public class CglibTest {
    @Test
    public void Test()
    {
        CglibProxy cglibProxy = new CglibProxy();
        CgUserService service = (CgUserService)cglibProxy.getProxy(CgUserService.class);
        service.sayHello();
    }

}
