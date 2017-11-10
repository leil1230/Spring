package com.smart.factoryinject;

public class CarFactory {

    // 创建Car的工厂方法
    public static Car createAudiCar()
    {
        Car car = new Car();
        car.setBrand("Audi");
        car.setMaxSpeed(280);
        return car;
    }
}
