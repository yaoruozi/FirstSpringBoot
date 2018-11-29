package com.springboot.webtest.controller;

import com.springboot.webtest.common.model.User;
import com.springboot.webtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author:yao
 * Date:2018-11-29-22:15
 */
@Controller
public class HelloFreemarkerController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/helloUser")
    public String hello(ModelMap modelMap) {
        List<User> userList = userService.getUsers();
        User oneUser = userList.get(0); //第一个人
        modelMap.put("user",oneUser);
        return "hello"; //这里返回的结果是freemarker文件的名字
    }

    @RequestMapping(value="/index")
    public String showIndex(){
        return "homepage/index";
    }

}
