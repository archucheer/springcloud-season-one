package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
import java.util.Optional;

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
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public User get(@PathVariable("id") int id){
        User user = userService.getUser(id);

        Optional<User> optionalUser = Optional.ofNullable(user);
        //为空则抛出异常
        optionalUser.orElseThrow(RuntimeException::new);

        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list(){
        return userService.getUserList();
    }

    //服务请求熔断时执行该方法返回信息
    public User processHystrix_Get(@PathVariable("id")  int id){
        User user = new User();
        user.setId(id);
        user.setLastname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
        user.setDbSource("no this database in MySQL");
        return user;
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
