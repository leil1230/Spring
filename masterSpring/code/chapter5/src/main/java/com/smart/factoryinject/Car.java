package com.smart.factoryinject;

public class Car {
    private String brand;

    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void introduce()
    {
        System.out.println("brand:" + brand);
        System.out.println("max speed:" + maxSpeed);
    }
}
