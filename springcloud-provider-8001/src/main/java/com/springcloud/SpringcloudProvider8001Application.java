package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
@MapperScan("com.springcloud.dao")
public class SpringcloudProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8001Application.class, args);
    }

}
