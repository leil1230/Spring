package com.smart.context

import com.smart.Car

beans {
car(Car)    // 名字（类型）
        {
            // 注入属性
            brand = "红旗CA72";
            maxSpeed = 500;
            color = "Gray";
        }
}
