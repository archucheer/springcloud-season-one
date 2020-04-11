package com.springcloud.controller;

import com.springcloud.model.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ccz
 * @Date: 2020/4/9 10:46
 * @Description:
 */
@RestController
public class HttpController {


    @Autowired
    private UserService userService;



    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list(){
        return userService.getUserList();
    }




    //提供服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dep/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("****" + list);

        List<ServiceInstance> srvList = client.getInstances("SPRINGCLOUD-PROVIDER-DEP");
        for (ServiceInstance s:srvList) {
            System.out.println(s.getServiceId() +"\t"+ s.getHost() +"\t"+ s.getPort() +"\t"+ s.getUri());
        }

        for (String service:list) {

        }

        return client;
    }
}
