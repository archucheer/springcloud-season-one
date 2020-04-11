package com.springcloud.controller;

import com.springcloud.service.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ccz
 * @Date: 2020/4/9 12:05
 * @Description:
 */
@RestController
public class HttpController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/consumer/user/get/{id}",method = RequestMethod.GET)
    public User get(@PathVariable("id") int id)
    {
        return userService.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/user/list",method = RequestMethod.GET)
    public List<User> list()
    {
        return userService.list();
    }



}