package com.smart.context;

import com.smart.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 表示是一个配置信息提供类
@Configuration
public class Beans {

    // 定义一个Bean
    @Bean(name = "car")
    public Car buildCar()
    {
        Car car = new Car();
        car.setBrand("Audi");
        car.setColor("银色");
        car.setMaxSpeed(400);
        return car;
    }
}
