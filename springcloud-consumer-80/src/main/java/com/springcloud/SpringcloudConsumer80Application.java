package com.springcloud;

import com.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效,针对指定服务的负载均衡策略
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEP",configuration= MySelfRule.class)
public class SpringcloudConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumer80Application.class, args);
    }

}
