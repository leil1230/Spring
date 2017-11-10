package com.smart.factoryinject;

public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void introduceCar()
    {
        car.introduce();
    }
}
