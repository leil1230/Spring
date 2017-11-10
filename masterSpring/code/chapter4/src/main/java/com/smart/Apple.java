package com.smart;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Apple {
    // 颜色
    private String color;

    // 味道
    private String flavour;

    public Apple(String color, String flavour)
    {
        this.color = color;
        this.flavour = flavour;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

//    @PostConstruct
//    public void init()
//    {
//        System.out.println("苹果：" + color + "===" + flavour);
//    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("苹果对象被销毁了");
    }
}
