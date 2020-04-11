package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudConfigEurekaClient7001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigEurekaClient7001Application.class, args);
    }

}
