package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSourceExample {
    // 类路径
    private static final String PATH = "com/smart/txt/file.txt";

    public static void main(String[] args) throws IOException {

        // 使用类路径方式加载文件
        Resource res = new ClassPathResource(PATH);
        // 对资源进行编码
        EncodedResource encodedResource = new EncodedResource(res, "UTF-8");
        String content = FileCopyUtils.copyToString(encodedResource.getReader());
        System.out.println(content);
    }

}
