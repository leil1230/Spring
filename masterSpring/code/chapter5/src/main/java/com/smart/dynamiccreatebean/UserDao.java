package com.smart.dynamiccreatebean;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void sayHi()
    {
        System.out.println("Hello, I am UserDao");
    }
}
