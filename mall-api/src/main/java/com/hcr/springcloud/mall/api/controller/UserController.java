package com.hcr.springcloud.mall.api.controller;

import com.hcr.springcloud.common.util.Result;
import com.hcr.springcloud.mall.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public Result<String> login(String userName, String password) {
        return userService.login(userName, password);
    }
}