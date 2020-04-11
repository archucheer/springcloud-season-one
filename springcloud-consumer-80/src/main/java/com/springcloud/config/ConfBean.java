package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: ccz
 * @Date: 2020/4/9 20:01
 * @Description:
 */
@Configuration
public class ConfBean {

    @Bean
    @LoadBalanced/*ribbon 负载均衡 SpringCloud是基于Netflix Ribbon实现的一套客户端 负载均衡工具
                   默认以轮询的方式依次访问同一个实例下的每个节点*/
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Bean
    public IRule myRule(){//自定义负载均衡访问规则
//        return new RandomRule();//随机访问
        return new RetryRule();//每次还是采用RoundRobinRule中的choose规则来选择一个服务实例，如果选到的实例正常就返回，如果选择的服务实例为null或者已经失效，则在失效时间deadline之前不断的进行重试（重试时获取服务的策略还是RoundRobinRule中定义的策略），如果超过了deadline还是没取到则会返回一个null。
    }
}
