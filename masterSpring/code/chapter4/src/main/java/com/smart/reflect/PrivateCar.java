package com.smart.reflect;

public class PrivateCar {

    private String color;

    protected void drive()
    {
        System.out.println("Drive private car..." + color);
    }
}
