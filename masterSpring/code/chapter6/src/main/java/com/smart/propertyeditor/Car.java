package com.smart.propertyeditor;

public class Car {
    private String brand;

    private int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void introduce()
    {
        System.out.println(brand + "==" + maxSpeed);
    }
}
