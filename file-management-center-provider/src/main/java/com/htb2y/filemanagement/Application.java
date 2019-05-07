package com.htb2y.filemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.htb2y.filemanagement"})
//@EnableEurekaClient
//@EnableFeignClients
@Configuration
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        System.out.println("文件管理中心启动成功");
        System.out.println("--->ok");
    }
    @Autowired
    private Environment env;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(env.getProperty("multipart.maxFileSize")); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(env.getProperty("multipart.maxRequestSize"));
        return factory.createMultipartConfig();
    }
}
