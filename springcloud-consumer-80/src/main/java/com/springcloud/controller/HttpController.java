package com.springcloud.controller;

import com.springcloud.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: ccz
 * @Date: 2020/4/9 12:05
 * @Description:
 */
@RestController
public class HttpController {


    @Autowired
    RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEP";


    @RequestMapping(value = "/consumer/user/get/{id}")
    public User get(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, User.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/user/list")
    public List<User> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
    }


    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dep/discovery", method = RequestMethod.GET)
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dep/discovery", Object.class);
    }


}