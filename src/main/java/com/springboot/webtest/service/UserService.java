package com.springboot.webtest.service;

import com.springboot.webtest.common.model.User;
import com.springboot.webtest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:yao
 * Date:2018-11-28-10:42
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.selectUsers();
    }

}
