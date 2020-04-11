package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: ccz
 * @Date: 2020/4/10 14:07
 * @Description:
 */
/**
 * feign负载均衡 面向接口 声明式的负载均衡
 */

//@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEP")
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEP",fallbackFactory=UserClientServiceFallbackFactory.class)
public interface UserService {


    @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
    public User get(@PathVariable("id") int id);

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public List<User> list();







}
