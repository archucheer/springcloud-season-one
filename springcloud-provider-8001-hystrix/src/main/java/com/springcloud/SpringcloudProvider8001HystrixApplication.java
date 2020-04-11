package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
@MapperScan("com.springcloud.dao")
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class SpringcloudProvider8001HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8001HystrixApplication.class, args);
    }

    /*
        springboot2.0以上版本需要添加这个配置
        或者在配置文件中配置
        management:
          endpoints:
            web:
              exposure:
               include: hystrix.stream
     */
//    @Bean
//    public ServletRegistrationBean getServlet(){
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }


}
