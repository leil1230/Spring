package com.smart.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

// 断言测试必须引入
import static org.testng.Assert.*;

import java.io.IOException;

public class PatternResolverTest {
    @Test
    public void getResouces() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 加载所有类包com.smart(及子孙包)下以.xml为后缀的资源
        Resource resources[] = resolver.getResources("classpath*:com/smart/**/*.xml");
        assertNotNull(resources);
        for (Resource resource : resources)
        {
            System.out.println(resource.getDescription());
        }
    }
}
