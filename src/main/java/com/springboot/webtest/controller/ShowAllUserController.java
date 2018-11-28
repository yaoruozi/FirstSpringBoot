package com.springboot.webtest.controller;

import com.springboot.webtest.common.model.User;
import com.springboot.webtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:yao
 * Date:2018-11-28-10:37
 */
@RestController
public class ShowAllUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showUsers")
    public List<User> showUserList() {
        return userService.getUsers();
    }
}
