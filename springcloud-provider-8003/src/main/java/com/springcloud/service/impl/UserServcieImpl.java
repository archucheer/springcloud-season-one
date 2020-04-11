package com.springcloud.service.impl;

import com.springcloud.dao.UserMapper;
import com.springcloud.model.User;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ccz
 * @Date: 2020/4/9 22:55
 * @Description:
 */
@Service
public class UserServcieImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getUserList() {
        return userMapper.selectAll();
    }
}
