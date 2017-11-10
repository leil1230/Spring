package com.smart.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TestConfig {

    @Bean(name = "testMap")
    public Map<String, String> getTestMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "bbb");
        map.put("ccc", "ddd");
        return map;
    }

}
