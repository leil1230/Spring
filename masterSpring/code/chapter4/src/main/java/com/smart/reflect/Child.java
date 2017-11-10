package com.smart.reflect;

public class Child {

    private String name;

    private int age;

    public Child(){}

    public Child(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void introduce()
    {
        System.out.println("我的名字叫" + name + ",我今年" + age + "岁");
    }


}
