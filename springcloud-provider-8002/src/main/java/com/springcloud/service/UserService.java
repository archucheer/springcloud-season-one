package com.springcloud.service;

import com.springcloud.model.User;

import java.util.List;

/**
 * @Auther: ccz
 * @Date: 2020/4/9 22:56
 * @Description:
 */
public interface UserService {

    User getUser(int id);

    List<User> getUserList();
}
