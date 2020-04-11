package com.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: ccz
 * @Date: 2020/4/10 00:03
 * @Description:
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){//自定义负载均衡访问规则
//        return new RandomRule();//随机访问
//        return new RetryRule();//每次还是采用RoundRobinRule中的choose规则来选择一个服务实例，如果选到的实例正常就返回，如果选择的服务实例为null或者已经失效，则在失效时间deadline之前不断的进行重试（重试时获取服务的策略还是RoundRobinRule中定义的策略），如果超过了deadline还是没取到则会返回一个null。
        return new RandomRule_CZ();


    }
}
