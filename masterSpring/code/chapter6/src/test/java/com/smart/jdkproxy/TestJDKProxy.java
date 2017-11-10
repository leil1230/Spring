package com.smart.jdkproxy;

import com.smart.jdkproxy2.MyInvocationHandler;
import com.smart.jdkproxy2.UserService;
import com.smart.jdkproxy2.UserServiceImpl;
import org.testng.annotations.Test;

public class TestJDKProxy {

    @Test
    public void Test()
    {
        UserService userServiceImpl = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userServiceImpl);
        UserService userServiceProxy = (UserService)handler.getProxy();
        userServiceProxy.sayHello();
    }

}
